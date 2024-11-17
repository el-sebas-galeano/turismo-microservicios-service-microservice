package com.turismo.service_microservice.service;

import java.util.List;

import com.turismo.service_microservice.entity.Calificacion;

public interface ICalificacionService {
    Calificacion crearCalificacion(Calificacion calificacion);
    Calificacion actualizarCalificacion(Long id, Calificacion calificacion);
    void eliminarCalificacion(Long id);
    Calificacion obtenerCalificacionPorId(Long id);
    List<Calificacion> obtenerCalificacionesPorServicio(Long servicioId);
    double calcularPromedioCalificaciones(Long servicioId);
}
