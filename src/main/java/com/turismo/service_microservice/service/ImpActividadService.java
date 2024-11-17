package com.turismo.service_microservice.service;

import org.springframework.stereotype.Service;

import com.turismo.service_microservice.entity.Actividad;
import com.turismo.service_microservice.repository.ActividadRepository;

@Service
public class ImpActividadService extends ImpServicioService<Actividad> implements IActividadService {
    
    public ImpActividadService(ActividadRepository actividadRepository){
        super(actividadRepository);
    }
}
