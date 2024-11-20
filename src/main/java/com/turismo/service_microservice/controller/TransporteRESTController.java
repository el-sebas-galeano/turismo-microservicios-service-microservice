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

import com.turismo.service_microservice.entity.EstadoServicio;
import com.turismo.service_microservice.entity.Transporte;
import com.turismo.service_microservice.service.ITransporteService;

@RestController
@RequestMapping("/transporte")
public class TransporteRESTController {

    private final ITransporteService transporteService;

    public TransporteRESTController(ITransporteService transporteService) {
        this.transporteService = transporteService;
    }

    @PostMapping
    public ResponseEntity<Transporte> crearTransporte(@RequestBody Transporte transporte) {
        Transporte nuevoTransporte = transporteService.crearServicio(transporte);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoTransporte);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transporte> actualizarTransporte(@PathVariable Long id, @RequestBody Transporte transporte) {
        Transporte actualizado = transporteService.actualizarServicio(id, transporte);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTransporte(@PathVariable Long id) {
        transporteService.eliminarServicio(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transporte> obtenerTransportePorId(@PathVariable Long id) {
        Transporte transporte = transporteService.obtenerServiciosPorId(id);
        return ResponseEntity.ok(transporte);
    }

    @GetMapping("/estado")
    public ResponseEntity<List<Transporte>> obtenerTransportesPorEstado(
            @RequestParam(name = "estado", required = false, defaultValue = "DISPONIBLE") EstadoServicio estado) {
        List<Transporte> transportes = transporteService.obtenerServiciosPorEstado(estado);
        return ResponseEntity.ok(transportes);
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<Transporte>> obtenerTransportesPorIdUsuario(@PathVariable Long idUsuario) {
        List<Transporte> transportes = transporteService.obtenerServiciosPorIdUsuario(idUsuario);
        return ResponseEntity.ok(transportes);
    }

    @GetMapping("/nombre")
    public ResponseEntity<List<Transporte>> obtenerTransportesPorNombre(
            @RequestParam(name = "nombre", required = false, defaultValue = "") String nombre) {
        List<Transporte> transportes = transporteService.obtenerServiciosPorNombre(nombre);
        return ResponseEntity.ok(transportes);
    }
}

