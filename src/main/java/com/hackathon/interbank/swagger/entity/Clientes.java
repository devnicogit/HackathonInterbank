package com.hackathon.interbank.swagger.entity;

import com.hackathon.interbank.security.entity.Usuario;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cliente")
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cliente_id;

    private String direccion;
    private int numPedidos;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "cliente")
    private Set<CarritoCompras> carritos;

    @OneToMany(mappedBy = "cliente")
    private Set<Pedido> pedidos;

    public Clientes() {
    }

    public Clientes(Long cliente_id, String direccion, int numPedidos, Usuario usuario, Set<CarritoCompras> carritos, Set<Pedido> pedidos) {
        this.cliente_id = cliente_id;
        this.direccion = direccion;
        this.numPedidos = numPedidos;
        this.usuario = usuario;
        this.carritos = carritos;
        this.pedidos = pedidos;
    }

    public Clientes(String direccion, int numPedidos, Usuario usuario, Set<CarritoCompras> carritos, Set<Pedido> pedidos) {
        this.direccion = direccion;
        this.numPedidos = numPedidos;
        this.usuario = usuario;
        this.carritos = carritos;
        this.pedidos = pedidos;
    }

    public Clientes(String direccion, int numPedidos, Usuario usuario) {
        this.direccion = direccion;
        this.numPedidos = numPedidos;
        this.usuario = usuario;
    }

    public Long getClienteID() {
        return cliente_id;
    }

    public void setClienteID(Long cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumPedidos() {
        return numPedidos;
    }

    public void setNumPedidos(int numPedidos) {
        this.numPedidos = numPedidos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Set<CarritoCompras> getCarritos() {
        return carritos;
    }

    public void setCarritos(Set<CarritoCompras> carritos) {
        this.carritos = carritos;
    }

    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
