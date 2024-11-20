package com.turismo.service_microservice.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.turismo.service_microservice.entity.Hospedaje;

@Repository
public interface HospedajeRepository extends ServicioRepository<Hospedaje> {
    List<Hospedaje> findByNombre(String nombre);
}
