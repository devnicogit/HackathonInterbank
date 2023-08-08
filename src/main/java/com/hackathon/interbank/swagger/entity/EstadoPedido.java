package com.hackathon.interbank.swagger.entity;

import javax.persistence.*;

@Entity
public class EstadoPedido
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "estado_id")
    private Long id;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    public EstadoPedido(){}

    public EstadoPedido(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public EstadoPedido(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
