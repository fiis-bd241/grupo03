package com.example.bcp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "\"Estado\"")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"Estado_Id\"")
    private Integer estadoId;

    @Column(name = "\"Estado_Tipo\"", length = 10)
    private String estadoTipo;

    public Estado() {
        // Constructor por defecto
    }

    public Estado(Integer estadoId, String estadoTipo) {
        this.estadoId = estadoId;
        this.estadoTipo = estadoTipo;
    }

    // Getters and Setters
    public Integer getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Integer estadoId) {
        this.estadoId = estadoId;
    }

    public String getEstadoTipo() {
        return estadoTipo;
    }

    public void setEstadoTipo(String estadoTipo) {
        this.estadoTipo = estadoTipo;
    }
}
