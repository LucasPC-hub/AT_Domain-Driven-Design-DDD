package br.edu.infnet.pedidos.infra.service;

import br.edu.infnet.pedidos.domain.Pedido;
import br.edu.infnet.pedidos.domain.PedidoStatus;
import br.edu.infnet.pedidos.eventos.EstadoPedidoMudou;
import br.edu.infnet.pedidos.infra.repository.PedidoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    private static final Logger LOG = LoggerFactory.getLogger(PedidoService.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private PedidoRepository repository;

    public Pedido obterPorId(long id) {
        return repository.getReferenceById(id);
    }

    public Pedido fecharPedido(long id) {
        Pedido pedido = repository.getReferenceById(id);
        pedido.fecharPedido();
        pedido = repository.save(pedido);
        enviar(new EstadoPedidoMudou(pedido.getId(), PedidoStatus.FECHADO));
        return pedido;
    }

    public Pedido criarPedido(Pedido pedido) {
        Pedido retorno = null;
        if (pedido != null) {
            retorno = repository.save(pedido);
            enviar(new EstadoPedidoMudou(pedido.getId(), PedidoStatus.NOVO));
        }
        return retorno;
    }

    public void processarEvento(EstadoPedidoMudou evento) {
        switch (evento.getEstado().toString()) {
            case "NOVO":
                break;
            case "EM_TRANSITO":
                break;
        }
    }

    public void enviar(EstadoPedidoMudou estado) {
        rabbitTemplate.convertAndSend("PetFriends_Pedidos", estado);
        LOG.info("***** Mensagem Publicada ---> " + estado);
    }

    @RabbitListener(queues = "PetFriends_Pedidos")
    private void receber(EstadoPedidoMudou payload) {
        LOG.info("***** Mensagem Recebida ---> " + payload);
        this.processarEvento(payload);
    }
}