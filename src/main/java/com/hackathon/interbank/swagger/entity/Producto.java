package com.hackathon.interbank.swagger.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long producto_id;


    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id")
    @JsonProperty("categoria")
    private Categoria categoria;

    @Column(name = "igv", nullable = false)
    private Boolean igv;

    @Column(name = "imagen", nullable = false)
    private String imagen;

    @Column(name = "precio", nullable = false)
    private BigDecimal precio;

    @Column(name = "descuento", nullable = false)
    private BigDecimal descuento;

    public Producto(){}

    public Producto(Long producto_id, String nombre, String descripcion, Categoria categoria, Boolean igv, String imagen, BigDecimal precio, BigDecimal descuento) {
        this.producto_id = producto_id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.igv = igv;
        this.imagen = imagen;
        this.precio = precio;
        this.descuento = descuento;
    }

    public Producto(String nombre, String descripcion, Categoria categoria, Boolean igv, String imagen, BigDecimal precio, BigDecimal descuento) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.igv = igv;
        this.imagen = imagen;
        this.precio = precio;
        this.descuento = descuento;
    }

    public Long getId() {
        return producto_id;
    }

    public void setId(Long producto_id) {
        this.producto_id = producto_id;
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

    public Boolean getIgv() {
        return igv;
    }

    public void setIgv(Boolean igv) {
        this.igv = igv;
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

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }
}
