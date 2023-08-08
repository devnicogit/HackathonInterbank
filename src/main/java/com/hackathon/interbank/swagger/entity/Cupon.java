package com.hackathon.interbank.swagger.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cupon")
public class Cupon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cupon_id")
    private Long id;
    @Column(name = "codigo", unique = true, nullable = false)
    private String codigo;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    @Column(name = "descuento", nullable = false)
    private BigDecimal descuento;


    public Cupon(){}


    public Cupon(Long id, String codigo, String descripcion, BigDecimal descuento) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.descuento = descuento;
    }

    public Cupon(String codigo, String descripcion, BigDecimal descuento) {
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

