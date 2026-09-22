package org.example.config;

import org.example.dto.ServicioDTO;
import org.example.models.CentroServicio;
import org.example.repository.CentroServicioRepository;
import org.example.service.ServicioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;


@Configuration
public class DemoDataLoader {


    //@Configuration + @Bean CommandLineRunner es el patrón que usa Spring Boot para ejecutar código automáticamente apenas arranca la app
    // (después de armar el contexto, con la BD ya lista).
    @Bean
    CommandLineRunner demo(CentroServicioRepository centroServicioRepository, ServicioService servicioService){

        return args -> {

            //Primero creo la clase "padre" el centro
            CentroServicio centroServicio = new CentroServicio();
            centroServicio.setCuit("20202020");
            centroServicio.setDireccion("calle 1");
            centroServicio.setRazonSocial("Centro SRL");
            centroServicio.setEmail("contacto@centrosrl.com");
            centroServicioRepository.save(centroServicio);


            ServicioDTO servicio = new ServicioDTO(centroServicio.getCuit(),"cambiar aceite","nuevo nuevo", 120,new BigDecimal(20000));
            servicioService.registrarServicio(servicio);

        }
    }



}
