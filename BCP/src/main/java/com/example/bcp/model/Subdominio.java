package com.example.bcp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "\"Subdominio\"")
public class Subdominio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"id_subdominio\"")
    private String idSubdominio;

    @Column(name = "\"nombre_subdominio\"")
    private String nombreSubdominio;

    @ManyToOne
    @JoinColumn(name = "\"id_dominio\"")
    private Dominio idDominio;

    public String getIdSubdominio() {
        return idSubdominio;
    }

    public void setIdSubdominio(String idSubdominio) {
        this.idSubdominio = idSubdominio;
    }

    public String getNombreSubdominio() {
        return nombreSubdominio;
    }

    public void setNombreSubdominio(String nombreSubdominio) {
        this.nombreSubdominio = nombreSubdominio;
    }

    public Dominio getIdDominio() {
        return idDominio;
    }

    public void setIdDominio(Dominio idDominio) {
        this.idDominio = idDominio;
    }
}
