package com.hackathon.interbank.swagger.entity;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "carritocompras")
public class CarritoCompras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carrito_id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Clientes cliente;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    private LocalDateTime fechaAgregado;

    public CarritoCompras() {
    }

    public CarritoCompras(Long carrito_id, Clientes cliente, Curso curso, LocalDateTime fechaAgregado) {
        this.carrito_id = carrito_id;
        this.cliente = cliente;
        this.curso = curso;
        this.fechaAgregado = fechaAgregado;
    }

    public CarritoCompras(Clientes cliente, Curso curso, LocalDateTime fechaAgregado) {
        this.cliente = cliente;
        this.curso = curso;
        this.fechaAgregado = fechaAgregado;
    }

    public Long getCarritoID() {
        return carrito_id;
    }

    public void setCarritoID(Long carrito_id) {
        this.carrito_id = carrito_id;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public LocalDateTime getFechaAgregado() {
        return fechaAgregado;
    }

    public void setFechaAgregado(LocalDateTime fechaAgregado) {
        this.fechaAgregado = fechaAgregado;
    }
}
