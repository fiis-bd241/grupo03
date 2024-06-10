package com.example.bcp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "\"Prioridad\"")
public class Prioridad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"Prioridad_Id\"")
    private Integer prioridadId;

    @Column(name = "\"Prioridad_Tipo\"", length = 5)
    private String prioridadTipo;

    @Column(name = "\"Prioridad_Detalle\"", length = 250)
    private String prioridadDetalle;

    public Prioridad() {
        // Constructor por defecto
    }

    // Getters and Setters

    public Integer getPrioridadId() {
        return prioridadId;
    }

    public void setPrioridadId(Integer prioridadId) {
        this.prioridadId = prioridadId;
    }

    public String getPrioridadTipo() {
        return prioridadTipo;
    }

    public void setPrioridadTipo(String prioridadTipo) {
        this.prioridadTipo = prioridadTipo;
    }

    public String getPrioridadDetalle() {
        return prioridadDetalle;
    }

    public void setPrioridadDetalle(String prioridadDetalle) {
        this.prioridadDetalle = prioridadDetalle;
    }

    public Prioridad(String prioridadTipo, String prioridadDetalle) {
        this.prioridadTipo = prioridadTipo;
        this.prioridadDetalle = prioridadDetalle;
    }
}
