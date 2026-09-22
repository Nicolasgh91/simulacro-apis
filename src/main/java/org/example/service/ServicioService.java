package org.example.service;

import jakarta.transaction.Transactional;
import org.example.dto.ServicioDTO;
import org.example.models.CentroServicio;
import org.example.models.Servicio;
import org.example.repository.CentroServicioRepository;
import org.example.repository.ServicioRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.math.BigDecimal;

@Service
public class ServicioService {
    private final ServicioRepository servicioRepository;// para poder persistir el nuevo servicio
    private final CentroServicioRepository centroServicioRepository;// primero tengo que encontrar el centro mediante su CUIT

    public ServicioService(ServicioRepository servicioRepository, CentroServicioRepository centroServicioRepository) {
        this.servicioRepository = servicioRepository;
        this.centroServicioRepository = centroServicioRepository;
    }

    @Transactional
    public Servicio registrarServicio(ServicioDTO dto){
        CentroServicio centroServicio = centroServicioRepository.findByCuit(dto.getCuitCentro());

        if (centroServicio == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No existe el centro buscado");
        }
        if (dto.getPrecio().compareTo(BigDecimal.ZERO) <= 0){
            throw new RuntimeException("Por favor indique un valor mayor a 0");
        }

        Servicio servicio = new Servicio();
        servicio.setNombre(dto.getNombre());
        servicio.setPrecio(dto.getPrecio());
        servicio.setDescripcion(dto.getDescripcion());
        servicio.setDuracionMinutos(dto.getDuracionMinutos());
        servicio.setCentroServicio(centroServicio);

        return servicioRepository.save(servicio);
    }
}
