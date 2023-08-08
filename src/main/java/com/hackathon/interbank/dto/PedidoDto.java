package com.hackathon.interbank.dto;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class PedidoDto {

    private Long pedido_id;
    private Date fecha;
    private BigDecimal subtotal;
    private BigDecimal igv;
    private BigDecimal total;

    private Long cliente;
    private Long estadoPedido;
    private Long cupon;


    public PedidoDto() {
    }

    public PedidoDto(Long pedido_id) {
        this.pedido_id = pedido_id;
    }

    public PedidoDto(Long pedido_id, Date fecha, BigDecimal subtotal, BigDecimal igv, BigDecimal total, Long cliente, Long estadoPedido, Long cupon) {
        this.pedido_id = pedido_id;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.igv = igv;
        this.total = total;
        this.cliente = cliente;
        this.estadoPedido = estadoPedido;
        this.cupon = cupon;
    }

    public PedidoDto(Date fecha, BigDecimal subtotal, BigDecimal igv, BigDecimal total, Long cliente, Long estadoPedido, Long cupon) {
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.igv = igv;
        this.total = total;
        this.cliente = cliente;
        this.estadoPedido = estadoPedido;
        this.cupon = cupon;
    }


    public Long getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(Long pedido_id) {
        this.pedido_id = pedido_id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getIgv() {
        return igv;
    }

    public void setIgv(BigDecimal igv) {
        this.igv = igv;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Long getCliente() {
        return cliente;
    }

    public void setCliente(Long cliente) {
        this.cliente = cliente;
    }

    public Long getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(Long estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public Long getCupon() {
        return cupon;
    }

    public void setCupon(Long cupon) {
        this.cupon = cupon;
    }

}
