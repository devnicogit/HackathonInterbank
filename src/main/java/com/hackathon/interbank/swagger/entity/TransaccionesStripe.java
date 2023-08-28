package com.hackathon.interbank.swagger.entity;

import javax.persistence.*;

@Entity
@Table(name = "transaccionesstripe")
public class TransaccionesStripe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transaccion_id;

    private String idTransaccionStripe;

    @OneToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    public TransaccionesStripe() {
    }

    public TransaccionesStripe(Long transaccion_id, String idTransaccionStripe, Pedido pedido) {
        this.transaccion_id = transaccion_id;
        this.idTransaccionStripe = idTransaccionStripe;
        this.pedido = pedido;
    }

    public TransaccionesStripe(String idTransaccionStripe, Pedido pedido) {
        this.idTransaccionStripe = idTransaccionStripe;
        this.pedido = pedido;
    }

    public Long getTransaccion_id() {
        return transaccion_id;
    }

    public void setTransaccion_id(Long transaccion_id) {
        this.transaccion_id = transaccion_id;
    }

    public String getIdTransaccionStripe() {
        return idTransaccionStripe;
    }

    public void setIdTransaccionStripe(String idTransaccionStripe) {
        this.idTransaccionStripe = idTransaccionStripe;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
