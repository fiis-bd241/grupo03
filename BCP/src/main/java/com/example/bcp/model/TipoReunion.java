package com.example.bcp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "\"Tipo_Reunion\"")
public class TipoReunion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"TipoReunion_Id\"")
    private Integer tipoReunionId;

    @Column(name = "\"Nombre\"")
    private String nombre;

    @Column(name = "\"Descripcion\"")
    private String descripcion;

    public TipoReunion() {
        super();
    }

    public TipoReunion(Integer tipoReunionId, String nombre, String descripcion) {
        super();
        this.tipoReunionId = tipoReunionId;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getTipoReunionId() {
        return tipoReunionId;
    }

    public void setTipoReunionId(Integer tipoReunionId) {
        this.tipoReunionId = tipoReunionId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}

