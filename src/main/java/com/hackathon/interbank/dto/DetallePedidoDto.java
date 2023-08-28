package com.hackathon.interbank.dto;

import java.math.BigDecimal;

public class DetallePedidoDto {

    private Long id;

    private Long pedido;

    private Long producto;
    private Integer cantidad;
    private BigDecimal subtotal;

    public DetallePedidoDto(){}

    public DetallePedidoDto(Long id, Long pedido, Long producto, Integer cantidad, BigDecimal subtotal) {
        this.id = id;
        this.pedido = pedido;
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public DetallePedidoDto(Long pedido, Long producto, Integer cantidad, BigDecimal subtotal) {
        this.pedido = pedido;
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPedido() {
        return pedido;
    }

    public void setPedido(Long pedido) {
        this.pedido = pedido;
    }

    public Long getProducto() {
        return producto;
    }

    public void setProducto(Long producto) {
        this.producto = producto;
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
