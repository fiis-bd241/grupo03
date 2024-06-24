package com.example.bcp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "\"TipoDato\"")
public class TipoDato
{
    @Id
    @Column(name = "\"id_TipoDeDato\"")
    private Integer tipoDeDatoId;
    @Column(name = "\"Nombre\"", length = 200)
    private String nombre;
    @Column(name = "\"Nivel de acceso\"", length = 200)
    private String nivelDeAcceso;
    @Column(name = "\"Enmascarado\"")
    private Boolean enmascarado;
    @Column(name = "\"Encriptación\"")
    private Boolean encriptacion;
    @OneToMany(mappedBy = "tipoDeDatoId")
    private List<Campo> campos;
    public TipoDato(Integer tipoDeDatoId, String nombre, String nivelDeAcceso, Boolean enmascarado, Boolean encriptacion) {
        this.tipoDeDatoId = tipoDeDatoId;
        this.nombre = nombre;
        this.nivelDeAcceso = nivelDeAcceso;
        this.enmascarado = enmascarado;
        this.encriptacion = encriptacion;
    }

    public TipoDato() {
    }

    public Integer getTipoDeDatoId() {
        return tipoDeDatoId;
    }

    public void setTipoDeDatoId(Integer tipoDeDatoId) {
        this.tipoDeDatoId = tipoDeDatoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivelDeAcceso() {
        return nivelDeAcceso;
    }

    public void setNivelDeAcceso(String nivelDeAcceso) {
        this.nivelDeAcceso = nivelDeAcceso;
    }

    public Boolean getEnmascarado() {
        return enmascarado;
    }

    public void setEnmascarado(Boolean enmascarado) {
        this.enmascarado = enmascarado;
    }

    public Boolean getEncriptacion() {
        return encriptacion;
    }

    public void setEncriptacion(Boolean encriptacion) {
        this.encriptacion = encriptacion;
    }
}
