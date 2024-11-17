package com.turismo.service_microservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.turismo.service_microservice.entity.EstadoServicio;
import com.turismo.service_microservice.entity.Servicio;

@NoRepositoryBean
public interface ServicioRepository<T extends Servicio> extends JpaRepository<T, Long> {
    List<T> findByEstado(EstadoServicio estado);
    List<T> findByNombre(String nombre);
}

