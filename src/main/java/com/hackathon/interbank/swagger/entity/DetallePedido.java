package com.hackathon.interbank.swagger.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long detalle_id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    private Integer cantidad;
    private BigDecimal subtotal;


    public DetallePedido(){}

    public DetallePedido(Long detalle_id, Pedido pedido, Curso curso, Integer cantidad, BigDecimal subtotal) {
        this.detalle_id = detalle_id;
        this.pedido = pedido;
        this.curso = curso;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public DetallePedido(Pedido pedido, Curso curso, Integer cantidad, BigDecimal subtotal) {
        this.pedido = pedido;
        this.curso = curso;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public Long getId() {
        return detalle_id;
    }

    public void setId(Long id) {
        this.detalle_id = detalle_id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}