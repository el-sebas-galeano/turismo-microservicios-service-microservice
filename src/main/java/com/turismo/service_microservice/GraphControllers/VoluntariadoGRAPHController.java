package com.turismo.service_microservice.GraphControllers;


import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.turismo.service_microservice.entity.EstadoServicio;
import com.turismo.service_microservice.entity.Voluntariado;
import com.turismo.service_microservice.service.IVoluntariadoService;

import java.util.List;

@Controller
public class VoluntariadoGRAPHController {

    private final IVoluntariadoService voluntariadoService;

    public VoluntariadoGRAPHController(IVoluntariadoService voluntariadoService) {
        this.voluntariadoService = voluntariadoService;
    }

   @QueryMapping
    public List<Voluntariado> obtenerVoluntariados() {
        return voluntariadoService.obtenerServiciosPorEstado(EstadoServicio.DISPONIBLE);
    }
   
    @QueryMapping
    public Voluntariado obtenerVoluntariadoPorId(@Argument Long id) {
        return voluntariadoService.obtenerServiciosPorId(id);
    }

     @QueryMapping
    public List<Voluntariado> obtenerVoluntariadosPorNombre(@Argument String nombre) {
        return voluntariadoService.obtenerServiciosPorNombre(nombre);
    }

}

