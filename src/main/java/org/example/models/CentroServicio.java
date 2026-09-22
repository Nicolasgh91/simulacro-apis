package org.example.models;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "centro_servicio")
public class CentroServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String cuit;
    @Column(nullable = false)
    private String razonSocial;
    @Column(nullable = false)
    private String email;
    private String direccion;
    @OneToMany (mappedBy = "centroServicio")
    private List<Servicio> servicios = new ArrayList<>();

    public CentroServicio(Long id, String cuit, String razonSocial, String email, String direccion, List<Servicio> servicios) {
        this.id = id;
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        this.email = email;
        this.direccion = direccion;
        this.servicios = servicios;
    }

    public CentroServicio(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public void cambioDeAceite(){
        System.out.println("Cambio de aceite realizado.");
    }

    public void alineacion(){
        System.out.println("Alineacion y balanceo realizado.");
    }

    public void diagnostico(){
        System.out.println("El auto no da más, necesita servicio completo.");
    }

    public void revisionGeneral(){
        System.out.println("Las cubiertas están gastadas. Los frenos no frenan y el acelerador no tiene tope.");
    }
}
