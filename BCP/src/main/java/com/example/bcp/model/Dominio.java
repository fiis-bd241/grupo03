package com.example.bcp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "\"Dominio\"")
public class Dominio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"id_dominio\"")
    private Integer idDominio;

    @Column(name = "\"tipo_dominio\"")
    private String nombreDominio;

    public Integer getIdDominio() {
        return idDominio;
    }

    public void setIdDominio(Integer idDominio) {
        this.idDominio = idDominio;
    }

    public String getNombreDominio() {
        return nombreDominio;
    }

    public void setNombreDominio(String nombreDominio) {
        this.nombreDominio = nombreDominio;
    }
}
