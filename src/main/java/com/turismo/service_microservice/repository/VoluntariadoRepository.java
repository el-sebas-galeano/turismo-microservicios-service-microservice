package com.turismo.service_microservice.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.turismo.service_microservice.entity.Voluntariado;

@Repository
public interface VoluntariadoRepository extends ServicioRepository<Voluntariado>{
    List<Voluntariado> findByNombre(String nombre);
}
