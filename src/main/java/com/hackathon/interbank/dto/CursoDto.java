package com.hackathon.interbank.dto;

import java.math.BigDecimal;

public class CursoDto {

    private Long curso_id;
    private String nombre;
    private String descripcion;
    private Long categoria;
    private String imagen;
    private BigDecimal precio;


    public CursoDto() {
    }

    public CursoDto(Long curso_id, String nombre, String descripcion, Long categoria, String imagen, BigDecimal precio) {
        this.curso_id = curso_id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.imagen = imagen;
        this.precio = precio;

    }

    public CursoDto(String nombre, String descripcion, Long categoria, String imagen, BigDecimal precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.imagen = imagen;
        this.precio = precio;
    }

    public Long getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(Long curso_id) {
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

    public Long getCategoria() {
        return categoria;
    }

    public void setCategoria(Long categoria) {
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
