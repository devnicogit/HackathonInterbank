package com.hackathon.interbank.dto;

import java.math.BigDecimal;

public class DetallePedidoDto {

    private Long detalle_id;

    private Long pedido;

    private Long curso;
    private Integer cantidad;
    private BigDecimal subtotal;

    public DetallePedidoDto(){}

    public DetallePedidoDto(Long detalle_id, Long pedido, Long curso, Integer cantidad, BigDecimal subtotal) {
        this.detalle_id = detalle_id;
        this.pedido = pedido;
        this.curso = curso;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public DetallePedidoDto(Long pedido, Long curso, Integer cantidad, BigDecimal subtotal) {
        this.pedido = pedido;
        this.curso = curso;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public Long getId() {
        return detalle_id;
    }

    public void setId(Long detalle_id) {
        this.detalle_id = detalle_id;
    }

    public Long getPedido() {
        return pedido;
    }

    public void setPedido(Long pedido) {
        this.pedido = pedido;
    }

    public Long getCurso() {
        return curso;
    }

    public void setCurso(Long curso) {
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
