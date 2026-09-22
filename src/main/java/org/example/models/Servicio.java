package org.example.models;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "servicio")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    private String descripcion;
    private Integer duracionMinutos;
    @Column(nullable = false)
    private BigDecimal precio;
    @ManyToOne(optional = false)
    @JoinColumn(name = "centro_id", nullable = false)
    private CentroServicio centroServicio;

    public Servicio(Long id, String nombre, String descripcion, Integer duracionMinutos, BigDecimal precio, CentroServicio centroServicio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracionMinutos = duracionMinutos;
        this.precio = precio;
        this.centroServicio = centroServicio;
    }

    public Servicio(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public CentroServicio getCentroServicio() {
        return centroServicio;
    }

    public void setCentroServicio(CentroServicio centroServicio) {
        this.centroServicio = centroServicio;
    }
}