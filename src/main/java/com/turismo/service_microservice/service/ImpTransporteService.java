package com.turismo.service_microservice.service;

import org.springframework.stereotype.Service;

import com.turismo.service_microservice.entity.Transporte;
import com.turismo.service_microservice.repository.TransporteRepository;

@Service
public class ImpTransporteService extends ImpServicioService<Transporte> implements ITransporteService{
    
    public ImpTransporteService(TransporteRepository transporteRepository) {
        super(transporteRepository);
    }
}
