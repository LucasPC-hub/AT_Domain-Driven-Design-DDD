package br.edu.infnet.controllers;

import br.edu.infnet.pedidos.domain.Pedido;
import br.edu.infnet.pedidos.eventos.EstadoPedidoMudou;
import br.edu.infnet.pedidos.infra.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/{id}")
    public Pedido obterPedidoPorId(@PathVariable long id) {
        return pedidoService.obterPorId(id);
    }

    @PostMapping
    public Pedido criarPedido(@RequestBody Pedido pedido) {
        return pedidoService.criarPedido(pedido);
    }

    @PostMapping("/{id}/fechar")
    public Pedido fecharPedido(@PathVariable long id) {
        return pedidoService.fecharPedido(id);
    }

    @PostMapping("/sendMessage")
    public String sendMessage(@RequestBody EstadoPedidoMudou estadoPedidoMudou) {
        pedidoService.enviar(estadoPedidoMudou);
        return "Mensagem enviada para o RabbitMQ: " + estadoPedidoMudou;
    }
}