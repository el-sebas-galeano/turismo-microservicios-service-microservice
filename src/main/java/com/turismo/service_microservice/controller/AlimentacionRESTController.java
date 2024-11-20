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

import com.turismo.service_microservice.entity.Alimentacion;
import com.turismo.service_microservice.entity.EstadoServicio;
import com.turismo.service_microservice.service.IAlimentacionService;

@RestController
@RequestMapping("/alimentacion")
public class AlimentacionRESTController {

    private final IAlimentacionService alimentacionService;

    public AlimentacionRESTController(IAlimentacionService alimentacionService) {
        this.alimentacionService = alimentacionService;
    }

    @PostMapping
    public ResponseEntity<Alimentacion> crearAlimentacion(@RequestBody Alimentacion alimentacion) {
        Alimentacion nuevaAlimentacion = alimentacionService.crearServicio(alimentacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaAlimentacion);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Alimentacion> actualizarAlimentacion(@PathVariable Long id, @RequestBody Alimentacion alimentacion) {
        Alimentacion actualizada = alimentacionService.actualizarServicio(id, alimentacion);
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> eliminarAlimentacion(@PathVariable Long id) {
        alimentacionService.eliminarServicio(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Alimentacion> obtenerAlimentacionPorId(@PathVariable Long id) {
        Alimentacion alimentacion = alimentacionService.obtenerServiciosPorId(id);
        return ResponseEntity.ok(alimentacion);
    }

    @GetMapping(path = "/estado")
    public ResponseEntity<List<Alimentacion>> obtenerAlimentacionesPorEstado(
            @RequestParam(name = "estado", required = false, defaultValue = "DISPONIBLE") EstadoServicio estado) {
        List<Alimentacion> alimentaciones = alimentacionService.obtenerServiciosPorEstado(estado);
        return ResponseEntity.ok(alimentaciones);
    }

    @GetMapping(path = "/nombre")
    public ResponseEntity<List<Alimentacion>> obtenerAlimentacionesPorNombre(
            @RequestParam(name = "nombre", required = false, defaultValue = "") String nombre) {
        List<Alimentacion> alimentaciones = alimentacionService.obtenerServiciosPorNombre(nombre);
        return ResponseEntity.ok(alimentaciones);
    }

    @GetMapping(path = "/usuario/{idUsuario}")
    public ResponseEntity<List<Alimentacion>> obtenerAlimentacionesPorIdUsuario(@PathVariable Long idUsuario) {
        List<Alimentacion> alimentaciones = alimentacionService.obtenerServiciosPorIdUsuario(idUsuario);
        return ResponseEntity.ok(alimentaciones);
    }
}
