package com.hackathon.interbank.swagger.entity;

import javax.persistence.*;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "categoria_id")
    private Long categoria_id;

    @Column(name = "nombre", unique = true, nullable = false)
    private String nombre;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    public Categoria() {
    }

    public Categoria(Long categoria_id, String nombre, String descripcion) {
        this.categoria_id = categoria_id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }


    public Categoria(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return categoria_id;
    }

    public void setId(Long categoria_id) {
        this.categoria_id = categoria_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
