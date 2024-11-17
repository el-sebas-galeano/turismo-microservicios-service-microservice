package com.turismo.service_microservice.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TRANSPORTE")
public class Transporte extends Servicio {

    @Column(name = "TIPO_TRANSPORTE")
    private TipoTransporte tipoTransporte;
    
    @Column(name = "FECHA_SALIDA")
    private LocalDateTime fechaSalida;

    @Column(name = "FECHA_LLEGADA")
    private LocalDateTime fechaLlegada;

    @Column(name = "CAPACIDAD")
    private int capacidad;

    @Column(name = "COSTO_POR_PASAJERO")
    private double costoPorPasajero;

    @Column(name = "ORIGEN_LATITUD")
    private double origenLatitud;

    @Column(name = "ORIGEN_LONGITUD")
    private double origenLongitud;

    @Column(name = "DESTINO_LATITUD")
    private double destinoLatitud;

    @Column(name = "DESTINO_LONGITUD")
    private double destinoLongitud;

    public Transporte() {
    }

    public TipoTransporte getTipoTransporte() {
        return tipoTransporte;
    }

    public void setTipoTransporte(TipoTransporte tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public LocalDateTime getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(LocalDateTime fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public double getCostoPorPasajero() {
        return costoPorPasajero;
    }

    public void setCostoPorPasajero(double costoPorPasajero) {
        this.costoPorPasajero = costoPorPasajero;
    }

    public double getOrigenLatitud() {
        return origenLatitud;
    }

    public void setOrigenLatitud(double origenLatitud) {
        this.origenLatitud = origenLatitud;
    }

    public double getOrigenLongitud() {
        return origenLongitud;
    }

    public void setOrigenLongitud(double origenLongitud) {
        this.origenLongitud = origenLongitud;
    }

    public double getDestinoLatitud() {
        return destinoLatitud;
    }

    public void setDestinoLatitud(double destinoLatitud) {
        this.destinoLatitud = destinoLatitud;
    }

    public double getDestinoLongitud() {
        return destinoLongitud;
    }

    public void setDestinoLongitud(double destinoLongitud) {
        this.destinoLongitud = destinoLongitud;
    }
}
