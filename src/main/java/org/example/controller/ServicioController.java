package org.example.controller;


import jakarta.transaction.Transactional;
import org.example.dto.ServicioDTO;
import org.example.service.ServicioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//El restcontroler indica que va a enviar y recibir peticiones HTTP
@RequestMapping("v1/servicios")//Define la URL base, es el endpoint
public class ServicioController {
    private final ServicioService servicioService;

    public ServicioController(ServicioService servicioService) {
        this.servicioService = servicioService;
    }

    @Transactional
    @PostMapping// Es el post, creacion de un nuevo recurso.
    public ResponseEntity<ServicioDTO> registrarServicio(@RequestBody ServicioDTO servicioDTO){
        servicioService.registrarServicio(servicioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(servicioDTO);
    }

}
