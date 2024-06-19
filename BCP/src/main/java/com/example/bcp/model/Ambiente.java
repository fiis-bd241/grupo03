package com.example.bcp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "\"Ambiente\"")
public class Ambiente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"id_ambiente\"")
    private Integer idAmbiente;

    @Column(name = "\"nombre_ambiente\"")
    private String nombreAmbiente;

    //Getters and Setters

    public Integer getIdAmbiente() {
        return idAmbiente;
    }

    public void setIdAmbiente(Integer idAmbiente) {
        this.idAmbiente = idAmbiente;
    }

    public String getNombreAmbiente() {
        return nombreAmbiente;
    }

    public void setNombreAmbiente(String nombreAmbiente) {
        this.nombreAmbiente = nombreAmbiente;
    }
}
