package com.turismo.service_microservice.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.turismo.service_microservice.entity.Transporte;

@Repository
public interface TransporteRepository extends ServicioRepository<Transporte>{
    List<Transporte> findByNombre(String nombre);
}
