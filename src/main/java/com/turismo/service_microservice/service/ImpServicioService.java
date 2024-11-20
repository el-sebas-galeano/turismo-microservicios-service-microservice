package com.turismo.service_microservice.service;

import java.util.List;

import com.turismo.service_microservice.entity.EstadoServicio;
import com.turismo.service_microservice.entity.Servicio;
import com.turismo.service_microservice.repository.ServicioRepository;

public abstract class ImpServicioService<T extends Servicio> implements IServicioService<T>{

    private final ServicioRepository <T> repositorio;

    public ImpServicioService(ServicioRepository<T> repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public T crearServicio(T servicio) {
        return repositorio.save(servicio);
    }

    @Override
    public T actualizarServicio(Long id, T servicio) {
        if (!repositorio.existsById(id)) {
            throw new IllegalArgumentException("Servicio no encontrado");
        }
        servicio.setIdServicio(id);
        return repositorio.save(servicio);
    }

    @Override
    public void eliminarServicio(Long id) {
        repositorio.deleteById(id);
    }

    @Override
    public T obtenerServiciosPorId(Long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Servicio no encontrado"));
    }

    @Override
    public List<T> obtenerServiciosPorEstado(EstadoServicio estado) {
        return repositorio.findByEstado(estado);
    }

    @Override
    public List<T> obtenerServiciosPorNombre(String nombre){
        return repositorio.findByNombre(nombre);
    }

    @Override
    public List<T> obtenerServiciosPorIdUsuario(Long idUsuario){
        return repositorio.findByIdUsuario(idUsuario);
    }
}
