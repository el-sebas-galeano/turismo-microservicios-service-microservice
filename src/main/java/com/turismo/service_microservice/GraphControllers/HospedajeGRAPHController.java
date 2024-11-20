package com.turismo.service_microservice.GraphControllers;


import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.turismo.service_microservice.entity.EstadoServicio;
import com.turismo.service_microservice.entity.Hospedaje;
import com.turismo.service_microservice.service.IHospedajeService;

import java.util.List;

@Controller
public class HospedajeGRAPHController {

    private final IHospedajeService hospedajeService;

    public HospedajeGRAPHController(IHospedajeService hospedajeService) {
        this.hospedajeService = hospedajeService;
    }

    @QueryMapping
    public List<Hospedaje> obtenerHospedajes() {
        return hospedajeService.obtenerServiciosPorEstado(EstadoServicio.DISPONIBLE);
    }

    @QueryMapping
    public Hospedaje obtenerHospedajePorId(@Argument Long id) {
        return hospedajeService.obtenerServiciosPorId(id);
    }

    @QueryMapping
    public List<Hospedaje> obtenerHospedajePorNombre(@Argument String nombre) {
        return hospedajeService.obtenerServiciosPorNombre(nombre);
    }

}
