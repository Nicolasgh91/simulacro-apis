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

            //1. creo la clase "padre" el centro
            CentroServicio centroServicio1 = new CentroServicio();
            centroServicio1.setCuit("20202020");
            centroServicio1.setDireccion("calle 1");
            centroServicio1.setRazonSocial("Centro SRL");
            centroServicio1.setEmail("contacto@centrosrl.com");
            centroServicioRepository.save(centroServicio1);
            System.out.println("Centro de servicios creado y registrado con éxito!");

            // 2. Creo un servicio para poder ofrecer distintos productos (servicios valga la redundancia)
            ServicioDTO servicio = new ServicioDTO(centroServicio1.getCuit(),"cambiar aceite","reemplazo completo de aceite y filtros", 120,new BigDecimal(20000));
            servicioService.registrarServicio(servicio);
            System.out.println("Servicio creado y registrado con éxito!");

            // pongo a prueba las validaciones
            try {
                ServicioDTO servicioTest = new ServicioDTO(centroServicio1.getCuit(),"precio negativo","test",10,new BigDecimal(0) );
                servicioService.registrarServicio(servicioTest);
            } catch (Exception e) {
                System.out.println("Se intengó cargar un servicio con precio inválido: " + e.getMessage());
            }




        };
    }



}
