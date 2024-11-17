package com.turismo.service_microservice.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;

@Entity
@Table(name = "VOLUNTARIADO")
public class Voluntariado extends Servicio{
    
    @Column(name = "OBJETIVO")
    private String objetivo;

    @Column(name = "DURACION")
    private int duracion;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> actividades;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> requerimientos;

    @Column(name = "UBICACION_LATITUD")
    private double ubicacionLatitud;

    @Column(name = "UBICACION_LONGITUD")
    private double ubicacionLongitud;

    @Column(name = "NOMBRE_UBICACION")
    private String nombreUbicacion;
    
    @Column(name = "COSTO")
    private double costo;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> beneficios;

    public Voluntariado() {
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public List<String> getActividades() {
        return actividades;
    }

    public void setActividades(List<String> actividades) {
        this.actividades = actividades;
    }

    public List<String> getRequerimientos() {
        return requerimientos;
    }

    public void setRequerimientos(List<String> requerimientos) {
        this.requerimientos = requerimientos;
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

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public List<String> getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(List<String> beneficios) {
        this.beneficios = beneficios;
    }
}
