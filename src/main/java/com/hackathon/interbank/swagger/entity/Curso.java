package com.hackathon.interbank.swagger.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long curso_id;


    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id")
    @JsonProperty("categoria")
    private Categoria categoria;

    @Column(name = "imagen", nullable = false)
    private String imagen;

    @Column(name = "precio", nullable = false)
    private BigDecimal precio;


    public Curso(){}

    public Curso(Long curso_id, String nombre, String descripcion, Categoria categoria,String imagen, BigDecimal precio) {
        this.curso_id = curso_id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.imagen = imagen;
        this.precio = precio;
    }

    public Curso(String nombre, String descripcion, Categoria categoria,String imagen, BigDecimal precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.imagen = imagen;
        this.precio = precio;
    }

    public Long getId() {
        return curso_id;
    }

    public void setId(Long curso_id) {
        this.curso_id = curso_id;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }


    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

}
