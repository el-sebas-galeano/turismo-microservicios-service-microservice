package com.turismo.service_microservice.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.turismo.service_microservice.entity.Actividad;

@Repository
public interface ActividadRepository extends ServicioRepository<Actividad>{
    List<Actividad> findByNombre(String nombre);
}
