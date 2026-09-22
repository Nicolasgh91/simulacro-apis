package org.example.repository;


import org.example.models.CentroServicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CentroServicioRepository extends JpaRepository<CentroServicio, Long> {

    CentroServicio findByCuit(String cuit);
}
