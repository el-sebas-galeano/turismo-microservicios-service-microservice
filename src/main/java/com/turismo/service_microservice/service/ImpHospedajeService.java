package com.turismo.service_microservice.service;

import org.springframework.stereotype.Service;

import com.turismo.service_microservice.entity.Hospedaje;
import com.turismo.service_microservice.repository.HospedajeRepository;

@Service
public class ImpHospedajeService extends ImpServicioService<Hospedaje> implements IHospedajeService {
    
    public ImpHospedajeService(HospedajeRepository hospedajeRepository){
        super(hospedajeRepository);
    }
}
