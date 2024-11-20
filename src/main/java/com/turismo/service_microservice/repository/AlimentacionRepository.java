package com.turismo.service_microservice.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.turismo.service_microservice.entity.Alimentacion;

@Repository
public interface AlimentacionRepository extends ServicioRepository<Alimentacion>{
    List<Alimentacion> findByNombre(String nombre);
}
