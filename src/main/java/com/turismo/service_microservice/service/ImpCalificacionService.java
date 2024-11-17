package com.turismo.service_microservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.turismo.service_microservice.entity.Calificacion;
import com.turismo.service_microservice.repository.CalificacionRepository;

@Service
public class ImpCalificacionService implements ICalificacionService{
    
    private final CalificacionRepository calificacionRepository;

    public ImpCalificacionService(CalificacionRepository calificacionRepository) {
        this.calificacionRepository = calificacionRepository;
    }

    @Override
    public Calificacion crearCalificacion(Calificacion calificacion) {
        return calificacionRepository.save(calificacion);
    }

    @Override
    public Calificacion actualizarCalificacion(Long id, Calificacion calificacion) {
        if (!calificacionRepository.existsById(id)) {
            throw new IllegalArgumentException("Calificación no encontrada");
        }
        calificacion.setIdCalificacion(id);
        return calificacionRepository.save(calificacion);
    }

    @Override
    public void eliminarCalificacion(Long id) {
        if (!calificacionRepository.existsById(id)) {
            throw new IllegalArgumentException("Calificación no encontrada");
        }
        calificacionRepository.deleteById(id);
    }

    @Override
    public Calificacion obtenerCalificacionPorId(Long id) {
        return calificacionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Calificación no encontrada"));
    }

    @Override
    public List<Calificacion> obtenerCalificacionesPorServicio(Long servicioId) {
        return calificacionRepository.findByServicio_IdServicio(servicioId);
    }

    @Override
    public double calcularPromedioCalificaciones(Long servicioId) {
        List<Calificacion> calificaciones = calificacionRepository.findByServicio_IdServicio(servicioId);
        if (calificaciones.isEmpty()) {
            return 0.0;
        }
        return calificaciones.stream()
                .mapToInt(Calificacion::getReputacion)
                .average()
                .orElse(0.0);
    }
    
}
