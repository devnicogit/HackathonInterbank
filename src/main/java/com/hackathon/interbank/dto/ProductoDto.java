package com.hackathon.interbank.dto;

import com.hackathon.interbank.swagger.entity.Categoria;

import java.math.BigDecimal;

public class ProductoDto {

    private Long producto_id;
    private String nombre;
    private String descripcion;
    private Long categoria;
    private Boolean igv;
    private String imagen;
    private BigDecimal precio;
    private BigDecimal descuento;

    public ProductoDto() {
    }

    public ProductoDto(Long producto_id, String nombre, String descripcion, Long categoria, Boolean igv, String imagen, BigDecimal precio, BigDecimal descuento) {
        this.producto_id = producto_id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.igv = igv;
        this.imagen = imagen;
        this.precio = precio;
        this.descuento = descuento;
    }

    public ProductoDto(String nombre, String descripcion, Long categoria, Boolean igv, String imagen, BigDecimal precio, BigDecimal descuento) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.igv = igv;
        this.imagen = imagen;
        this.precio = precio;
        this.descuento = descuento;
    }

    public Long getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(Long producto_id) {
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

    public Long getCategoria() {
        return categoria;
    }

    public void setCategoria(Long categoria) {
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
