package com.turismo.service_microservice.entity;

import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;

@Entity
@Table(name = "HOSPEDAJE")
public class Hospedaje extends Servicio{
    
    @Column(name = "TIPO_HOSPEDAJE")
    private TipoHospedaje tipoHospedaje;

    @Column(name = "CAPACIDAD_MAXIMA")
    private int capacidadMaxima;

    @Column(name = "DIAS")
    private int dias;

    @Column(name = "NOCHES")
    private int noches;

    @Column(name = "HORA_CHECKOUT")
    private LocalTime horaCheckOut;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> serviciosIncluidos;

    @Column(name = "UBICACION_LATITUD")
    private double ubicacionLatitud;

    @Column(name = "UBICACION_LONGITUD")
    private double ubicacionLongitud;

    @Column(name = "NOMBRE_UBICACION")
    private String nombreUbicacion;

    public Hospedaje() {
    }

    public TipoHospedaje getTipoHospedaje() {
        return tipoHospedaje;
    }

    public void setTipoHospedaje(TipoHospedaje tipoHospedaje) {
        this.tipoHospedaje = tipoHospedaje;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public int getNoches() {
        return noches;
    }

    public void setNoches(int noches) {
        this.noches = noches;
    }

    public LocalTime getHoraCheckOut() {
        return horaCheckOut;
    }

    public void setHoraCheckOut(LocalTime horaCheckOut) {
        this.horaCheckOut = horaCheckOut;
    }

    public List<String> getServiciosIncluidos() {
        return serviciosIncluidos;
    }

    public void setServiciosIncluidos(List<String> serviciosIncluidos) {
        this.serviciosIncluidos = serviciosIncluidos;
    }

    public double getUbicacionLatitud() {
        return ubicacionLatitud;
    }

    public void setUbicacionLatitud(double ubicacionLatitud) {
        this.ubicacionLatitud = ubicacionLatitud;
    }

    public double getUbicacionLongitud() {
        return ubicacionLongitud;
    }

    public void setUbicacionLongitud(double ubicacionLongitud) {
        this.ubicacionLongitud = ubicacionLongitud;
    }

    public String getNombreUbicacion() {
        return nombreUbicacion;
    }

    public void setNombreUbicacion(String nombreUbicacion) {
        this.nombreUbicacion = nombreUbicacion;
    }
}
