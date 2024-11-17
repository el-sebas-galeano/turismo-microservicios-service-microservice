package com.turismo.service_microservice.service;

import org.springframework.stereotype.Service;

import com.turismo.service_microservice.entity.Alimentacion;
import com.turismo.service_microservice.repository.AlimentacionRepository;

@Service
public class ImpAlimentacionService extends ImpServicioService<Alimentacion> implements IAlimentacionService{

    public ImpAlimentacionService(AlimentacionRepository alimentacionRepository){
        super(alimentacionRepository);
    }
}
