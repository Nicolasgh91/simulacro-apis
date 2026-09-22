package org.example.dto;

import java.math.BigDecimal;

public class ServicioDTO {
    private String cuitCentro;
    private String nombre;
    private String descripcion;
    private Integer duracionMinutos;
    private BigDecimal precio;

    public ServicioDTO(String cuitCentro, String nombre, String descripcion, Integer duracionMinutos, BigDecimal precio) {
        this.cuitCentro = cuitCentro;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracionMinutos = duracionMinutos;
        this.precio = precio;
    }

    public String getCuitCentro() {
        return cuitCentro;
    }

    public void setCuitCentro(String cuitCentro) {
        this.cuitCentro = cuitCentro;
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

    public Integer getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(Integer duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
}
