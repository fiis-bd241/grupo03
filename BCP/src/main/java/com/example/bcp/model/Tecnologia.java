package com.example.bcp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "\"Tecnologia\"")
public class Tecnologia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"id_tecnologia\"")
    private Integer TecnologiaId;

    @Column(name = "\"nombre_tecnologia\"", length = 50)
    private String nombreTecnologia;

    // Getters and Setters
    public Integer getTecnologiaId() {
        return TecnologiaId;
    }

    public void setTecnologiaId(Integer idTecnologia) {
        this.TecnologiaId = idTecnologia;
    }

    public String getNombreTecnologia() {
        return nombreTecnologia;
    }

    public void setNombreTecnologia(String nombreTecnologia) {
        this.nombreTecnologia = nombreTecnologia;
    }
}
