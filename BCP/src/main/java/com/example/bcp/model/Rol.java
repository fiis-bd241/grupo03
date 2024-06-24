package com.example.bcp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "\"Roles\"")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"id_rol\"")
    private Integer idRol;

    @Column(name = "\"nombre_rol\"")
    private String nombreRol;

    @Column(name = "\"nivel_acceso\"")
    private String nivelAcceso;

    // Constructor
    public Rol(Integer idRol, String nombreRol, String nivelAcceso) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
        this.nivelAcceso = nivelAcceso;
    }

    public Rol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public Rol() {
        super();
    }

    // Getters and Setters
    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getNivelAcceso() {
        return nivelAcceso;
    }

    public void setNivelAcceso(String nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }
}