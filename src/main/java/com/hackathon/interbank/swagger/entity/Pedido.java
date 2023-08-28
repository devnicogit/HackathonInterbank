package com.hackathon.interbank.swagger.entity;

import com.hackathon.interbank.security.entity.Usuario;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

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
    private Clientes cliente;
    @ManyToOne
    @JoinColumn(name = "estado_id")
    private EstadoPedido estado;
    @ManyToOne
    @JoinColumn(name = "cupon_id")
    private Cupon cupon;

    @OneToMany(mappedBy = "pedido")
    private Set<DetallePedido> detalles;

    @OneToOne(mappedBy = "pedido")
    private TransaccionesStripe transaccion;

    public Pedido(){}




    public Pedido(Long pedido_id, Date fecha, BigDecimal subtotal, BigDecimal igv, BigDecimal total, Clientes cliente, EstadoPedido estado, Cupon cupon) {
        this.pedido_id = pedido_id;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.igv = igv;
        this.total = total;
        this.cliente = cliente;
        this.estado = estado;
        this.cupon = cupon;
    }

    public Pedido(Date fecha, BigDecimal subtotal, BigDecimal igv, BigDecimal total, Clientes cliente, EstadoPedido estado, Cupon cupon) {
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.igv = igv;
        this.total = total;
        this.cliente = cliente;
        this.estado = estado;
        this.cupon = cupon;
    }

    public Pedido(Date fecha, BigDecimal subtotal, BigDecimal igv, BigDecimal total, Clientes cliente, EstadoPedido estado, Cupon cupon, Set<DetallePedido> detalles, TransaccionesStripe transaccion) {
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.igv = igv;
        this.total = total;
        this.cliente = cliente;
        this.estado = estado;
        this.cupon = cupon;
        this.detalles = detalles;
        this.transaccion = transaccion;
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

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
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
