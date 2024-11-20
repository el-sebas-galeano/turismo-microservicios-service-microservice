package com.turismo.service_microservice.service;

import java.util.List;

import com.turismo.service_microservice.entity.EstadoServicio;
import com.turismo.service_microservice.entity.Servicio;

public interface IServicioService <T extends Servicio>{
    T crearServicio(T servicio);
    T actualizarServicio(Long id, T servicio);
    void eliminarServicio(Long idServicio);
    T obtenerServiciosPorId(Long idServicio);
    List<T> obtenerServiciosPorEstado(EstadoServicio estado);
    List<T> obtenerServiciosPorNombre(String nombre);
    List<T> obtenerServiciosPorIdUsuario(Long idUsuario);
}
