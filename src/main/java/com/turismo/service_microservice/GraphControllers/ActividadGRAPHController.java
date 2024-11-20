package com.turismo.service_microservice.GraphControllers;


import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.turismo.service_microservice.entity.Actividad;
import com.turismo.service_microservice.entity.EstadoServicio;
import com.turismo.service_microservice.service.IActividadService;

import java.util.List;

@Controller
public class ActividadGRAPHController {

    private final IActividadService actividadService;

    public ActividadGRAPHController(IActividadService actividadService) {
        this.actividadService = actividadService;
    }

    @QueryMapping
    public List<Actividad> obtenerActividades() {
        return actividadService.obtenerServiciosPorEstado(EstadoServicio.DISPONIBLE); 
    }

    @QueryMapping
    public Actividad obtenerActividadPorId(@Argument Long id) {
        return actividadService.obtenerServiciosPorId(id);
    }

    @QueryMapping
    public List<Actividad> obtenerActividadesPorNombre(@Argument String nombre) {
        return actividadService.obtenerServiciosPorNombre(nombre);
    }
}