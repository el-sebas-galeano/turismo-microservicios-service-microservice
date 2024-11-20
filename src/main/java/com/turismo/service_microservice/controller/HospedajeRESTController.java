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

import com.turismo.service_microservice.entity.Hospedaje;
import com.turismo.service_microservice.entity.EstadoServicio;
import com.turismo.service_microservice.service.IHospedajeService;

@RestController
@RequestMapping("/hospedaje")
public class HospedajeRESTController {

    private final IHospedajeService hospedajeService;

    public HospedajeRESTController(IHospedajeService hospedajeService) {
        this.hospedajeService = hospedajeService;
    }

    @PostMapping
    public ResponseEntity<Hospedaje> crearHospedaje(@RequestBody Hospedaje hospedaje) {
        Hospedaje nuevoHospedaje = hospedajeService.crearServicio(hospedaje);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoHospedaje);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Hospedaje> actualizarHospedaje(@PathVariable Long id, @RequestBody Hospedaje hospedaje) {
        Hospedaje actualizado = hospedajeService.actualizarServicio(id, hospedaje);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> eliminarHospedaje(@PathVariable Long id) {
        hospedajeService.eliminarServicio(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Hospedaje> obtenerHospedajePorId(@PathVariable Long id) {
        Hospedaje hospedaje = hospedajeService.obtenerServiciosPorId(id);
        return ResponseEntity.ok(hospedaje);
    }

    @GetMapping(path = "/estado")
    public ResponseEntity<List<Hospedaje>> obtenerHospedajesPorEstado(
            @RequestParam(name = "estado", required = false, defaultValue = "DISPONIBLE") EstadoServicio estado) {
        List<Hospedaje> hospedajes = hospedajeService.obtenerServiciosPorEstado(estado);
        return ResponseEntity.ok(hospedajes);
    }

    @GetMapping(path = "/nombre")
    public ResponseEntity<List<Hospedaje>> obtenerHospedajesPorNombre(
            @RequestParam(name = "nombre", required = false, defaultValue = "") String nombre) {
        List<Hospedaje> hospedajes = hospedajeService.obtenerServiciosPorNombre(nombre);
        return ResponseEntity.ok(hospedajes);
    }

    @GetMapping(path = "/usuario/{idUsuario}")
    public ResponseEntity<List<Hospedaje>> obtenerHospedajesPorIdUsuario(@PathVariable Long idUsuario) {
        List<Hospedaje> hospedajes = hospedajeService.obtenerServiciosPorIdUsuario(idUsuario);
        return ResponseEntity.ok(hospedajes);
    }
}
