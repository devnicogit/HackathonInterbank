package com.hackathon.interbank.dto;

import javax.persistence.Column;
import java.math.BigDecimal;

public class CuponDto {

    private Long id;

    private String codigo;

    private String descripcion;

    private BigDecimal descuento;

    public CuponDto() {
    }

    public CuponDto(Long id, String codigo, String descripcion, BigDecimal descuento) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.descuento = descuento;
    }

    public CuponDto(String codigo, String descripcion, BigDecimal descuento) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.descuento = descuento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }
}
