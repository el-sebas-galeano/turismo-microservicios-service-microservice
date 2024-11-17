package com.turismo.service_microservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turismo.service_microservice.entity.Calificacion;
import com.turismo.service_microservice.service.ICalificacionService;

@RestController
@RequestMapping("/calificacion")
public class CalificacionRESTController {

    private final ICalificacionService calificacionService;

    public CalificacionRESTController(ICalificacionService calificacionService) {
        this.calificacionService = calificacionService;
    }

    @PostMapping
    public ResponseEntity<Calificacion> crearCalificacion(@RequestBody Calificacion calificacion) {
        Calificacion nuevaCalificacion = calificacionService.crearCalificacion(calificacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCalificacion);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Calificacion> actualizarCalificacion(@PathVariable Long id, @RequestBody Calificacion calificacion) {
        Calificacion actualizada = calificacionService.actualizarCalificacion(id, calificacion);
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> eliminarCalificacion(@PathVariable Long id) {
        calificacionService.eliminarCalificacion(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Calificacion> obtenerCalificacionPorId(@PathVariable Long id) {
        Calificacion calificacion = calificacionService.obtenerCalificacionPorId(id);
        return ResponseEntity.ok(calificacion);
    }

    @GetMapping(path = "/Calificacion/{servicioId}")
    public ResponseEntity<List<Calificacion>> obtenerCalificacionesPorServicio(@PathVariable Long servicioId) {
        List<Calificacion> calificaciones = calificacionService.obtenerCalificacionesPorServicio(servicioId);
        return ResponseEntity.ok(calificaciones);
    }

    @GetMapping(path = "/promedio/{servicioId}")
    public ResponseEntity<Double> calcularPromedioCalificaciones(@PathVariable Long servicioId) {
        double promedio = calificacionService.calcularPromedioCalificaciones(servicioId);
        return ResponseEntity.ok(promedio);
    }
}
