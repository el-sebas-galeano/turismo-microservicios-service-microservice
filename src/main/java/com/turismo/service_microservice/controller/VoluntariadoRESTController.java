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

import com.turismo.service_microservice.entity.Voluntariado;
import com.turismo.service_microservice.entity.EstadoServicio;
import com.turismo.service_microservice.service.IVoluntariadoService;

@RestController
@RequestMapping("/voluntariado")
public class VoluntariadoRESTController {

    private final IVoluntariadoService voluntariadoService;

    public VoluntariadoRESTController(IVoluntariadoService voluntariadoService) {
        this.voluntariadoService = voluntariadoService;
    }

    @PostMapping
    public ResponseEntity<Voluntariado> crearVoluntariado(@RequestBody Voluntariado voluntariado) {
        Voluntariado nuevoVoluntariado = voluntariadoService.crearServicio(voluntariado);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoVoluntariado);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Voluntariado> actualizarVoluntariado(@PathVariable Long id, @RequestBody Voluntariado voluntariado) {
        Voluntariado actualizado = voluntariadoService.actualizarServicio(id, voluntariado);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> eliminarVoluntariado(@PathVariable Long id) {
        voluntariadoService.eliminarServicio(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Voluntariado> obtenerVoluntariadoPorId(@PathVariable Long id) {
        Voluntariado voluntariado = voluntariadoService.obtenerServiciosPorId(id);
        return ResponseEntity.ok(voluntariado);
    }

    @GetMapping(path = "/estado")
    public ResponseEntity<List<Voluntariado>> obtenerVoluntariadosPorEstado(
            @RequestParam(name = "estado", required = false, defaultValue = "DISPONIBLE") EstadoServicio estado) {
        List<Voluntariado> voluntariados = voluntariadoService.obtenerServiciosPorEstado(estado);
        return ResponseEntity.ok(voluntariados);
    }

    @GetMapping(path = "/nombre")
    public ResponseEntity<List<Voluntariado>> obtenerVoluntariadosPorNombre(
            @RequestParam(name = "nombre", required = false, defaultValue = "") String nombre) {
        List<Voluntariado> voluntariados = voluntariadoService.obtenerServiciosPorNombre(nombre);
        return ResponseEntity.ok(voluntariados);
    }
}
