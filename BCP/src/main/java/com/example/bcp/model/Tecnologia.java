package com.example.bcp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "\"Tecnologia\"")
public class Tecnologia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"id_tecnologia\"")
    private Integer idTecnologia;

    @Column(name = "\"nombre_tecnologia\"", length = 50)
    private String nombreTecnologia;

    // Getters and Setters
    public Integer getIdTecnologia() {
        return idTecnologia;
    }

    public void setIdTecnologia(Integer idTecnologia) {
        this.idTecnologia = idTecnologia;
    }

    public String getNombreTecnologia() {
        return nombreTecnologia;
    }

    public void setNombreTecnologia(String nombreTecnologia) {
        this.nombreTecnologia = nombreTecnologia;
    }
}
