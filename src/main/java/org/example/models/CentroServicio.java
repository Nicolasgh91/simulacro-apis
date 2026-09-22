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
    @OneToMany (mappedBy = "centro")
    private List<Servicio> servicios = new ArrayList<>();

    public CentroServicio(Long id, String cuit, String razonSocial, String email, String direccion, List<Servicio> servicios) {
        this.id = id;
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        this.email = email;
        this.direccion = direccion;
        this.servicios = servicios;
    }


}
