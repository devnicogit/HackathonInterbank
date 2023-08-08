package com.hackathon.interbank.swagger.entity;

import com.hackathon.interbank.security.entity.Cliente;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pedido_id;
    private Date fecha;
    private BigDecimal subtotal;
    private BigDecimal igv;
    private BigDecimal total;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "estado_id")
    private EstadoPedido estado;
    @ManyToOne
    @JoinColumn(name = "cupon_id")
    private Cupon cupon;

    public Pedido(){}


    public Pedido(Long pedido_id, Date fecha, BigDecimal subtotal, BigDecimal igv, BigDecimal total, Cliente cliente, EstadoPedido estado, Cupon cupon) {
        this.pedido_id = pedido_id;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.igv = igv;
        this.total = total;
        this.cliente = cliente;
        this.estado = estado;
        this.cupon = cupon;
    }

    public Pedido(Date fecha, BigDecimal subtotal, BigDecimal igv, BigDecimal total, Cliente cliente, EstadoPedido estado, Cupon cupon) {
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.igv = igv;
        this.total = total;
        this.cliente = cliente;
        this.estado = estado;
        this.cupon = cupon;
    }


    public Long getId() {
        return pedido_id;
    }

    public void setId(Long pedido_id) {
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public Cupon getCupon() {
        return cupon;
    }

    public void setCupon(Cupon cupon) {
        this.cupon = cupon;
    }
}
