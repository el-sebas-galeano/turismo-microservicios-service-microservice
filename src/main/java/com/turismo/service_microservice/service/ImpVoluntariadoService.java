package com.turismo.service_microservice.service;

import org.springframework.stereotype.Service;

import com.turismo.service_microservice.entity.Voluntariado;
import com.turismo.service_microservice.repository.VoluntariadoRepository;

@Service
public class ImpVoluntariadoService extends ImpServicioService<Voluntariado> implements IVoluntariadoService {

    public ImpVoluntariadoService(VoluntariadoRepository voluntariadoRepository){
        super(voluntariadoRepository);
    }
}
