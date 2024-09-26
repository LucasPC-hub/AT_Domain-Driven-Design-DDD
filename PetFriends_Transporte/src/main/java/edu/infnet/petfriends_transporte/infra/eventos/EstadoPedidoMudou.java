package edu.infnet.petfriends_transporte.infra.eventos;

import java.util.Date;

public class EstadoPedidoMudou {

    private Long idPedido;
    private String estado;
    private Date momento;


    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getMomento() {
        return momento;
    }

    public void setMomento(Date momento) {
        this.momento = momento;
    }

    @Override
    public String toString() {
        return "EstadoPedidoMudou{" +
                "idPedido=" + idPedido +
                ", estado='" + estado + '\'' +
                ", momento=" + momento +
                '}';
    }
}