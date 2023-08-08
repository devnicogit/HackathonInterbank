package com.hackathon.interbank.dto;

import javax.persistence.Column;

public class EstadoPedidoDto {

    private Long id;
    private String descripcion;

    public EstadoPedidoDto() {
    }

    public EstadoPedidoDto(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public EstadoPedidoDto(String descripcion) {
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
