package com.techforb.backend.model;

import jakarta.persistence.*;

@Entity
public class Planta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pais;
    private String nombre;
    private int alertasMedias;
    private int alertasRojas;
    private int sensoresDeshabilitados;

    // Constructores, getters y setters

    public Planta() {
    }

    public Planta(String pais, String nombre, int alertasMedias, int alertasRojas, int sensoresDeshabilitados) {
        this.pais = pais;
        this.nombre = nombre;
        this.alertasMedias = alertasMedias;
        this.alertasRojas = alertasRojas;
        this.sensoresDeshabilitados = sensoresDeshabilitados;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAlertasMedias() {
        return alertasMedias;
    }

    public void setAlertasMedias(int alertasMedias) {
        this.alertasMedias = alertasMedias;
    }

    public int getAlertasRojas() {
        return alertasRojas;
    }

    public void setAlertasRojas(int alertasRojas) {
        this.alertasRojas = alertasRojas;
    }

    public int getSensoresDeshabilitados() {
        return sensoresDeshabilitados;
    }

    public void setSensoresDeshabilitados(int sensoresDeshabilitados) {
        this.sensoresDeshabilitados = sensoresDeshabilitados;
    }
}
