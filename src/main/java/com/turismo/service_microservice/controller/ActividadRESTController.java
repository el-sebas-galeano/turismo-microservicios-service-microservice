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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turismo.service_microservice.entity.Actividad;
import com.turismo.service_microservice.entity.EstadoServicio;
import com.turismo.service_microservice.service.IActividadService;

@RestController
@RequestMapping("/actividad")
public class ActividadRESTController {

    private final IActividadService actividadesService;

    public ActividadRESTController(IActividadService actividadesService) {
        this.actividadesService = actividadesService;
    }

    @PostMapping
    public ResponseEntity<Actividad> crearActividad(@RequestBody Actividad actividad) {
        Actividad nuevaActividad = actividadesService.crearServicio(actividad);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaActividad);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Actividad> actualizarActividad(@PathVariable Long id, @RequestBody Actividad actividad) {
        Actividad actualizada = actividadesService.actualizarServicio(id, actividad);
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> eliminarActividad(@PathVariable Long id) {
        actividadesService.eliminarServicio(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Actividad> obtenerActividadPorId(@PathVariable Long id) {
        Actividad actividad = actividadesService.obtenerServiciosPorId(id);
        return ResponseEntity.ok(actividad);
    }

    @GetMapping(path = "/estado")
    public ResponseEntity<List<Actividad>> obtenerActividadesPorEstado(
            @RequestParam(name = "estado", required = false, defaultValue = "DISPONIBLE") EstadoServicio estado) {
        List<Actividad> actividades = actividadesService.obtenerServiciosPorEstado(estado);
        return ResponseEntity.ok(actividades);
    }

    @GetMapping(path = "/nombre")
    public ResponseEntity<List<Actividad>> obtenerActividadesPorNombre(
            @RequestParam(name = "nombre", required = false, defaultValue = "") String nombre) {
        List<Actividad> actividades = actividadesService.obtenerServiciosPorNombre(nombre);
        return ResponseEntity.ok(actividades);
    }
}
