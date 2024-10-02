package com.turismo.service_microservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turismo.service_microservice.entity.Categoria;
import com.turismo.service_microservice.entity.Servicio;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Long>{
    
    List<Servicio> findByNombreContainingIgnoreCaseOrDescripcionContainingIgnoreCase(String nombre, String descripcion);

    List<Servicio> findByCategoria(Categoria category);
}
