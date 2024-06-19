package com.example.bcp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "\"ConceptosNegocio\"")
public class ConceptosNegocio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"id_CN\"")
    private Integer idCN;

    @ManyToOne
    @JoinColumn(name = "\"id_subdominio\"")
    private Subdominio idSubdominio;

    @ManyToOne
    @JoinColumn(name = "\"id_referencia\"")
    private DefinicionesTecnicas idReferencia;

    @Column(name = "\"DefinicionTabla\"")
    private String definicionTabla;

    @Column(name = "\"DefinicionCampo\"")
    private String definicionCampo;

    @ManyToOne
    @JoinColumn(name = "\"MigracionId\"")
    private Migracion idMigracion;

    public Integer getIdCN() {
        return idCN;
    }

    public void setIdCN(Integer idCN) {
        this.idCN = idCN;
    }

    public Subdominio getIdSubdominio() {
        return idSubdominio;
    }

    public void setIdSubdominio(Subdominio idSubdominio) {
        this.idSubdominio = idSubdominio;
    }

    public DefinicionesTecnicas getIdReferencia() {
        return idReferencia;
    }

    public void setIdReferencia(DefinicionesTecnicas idReferencia) {
        this.idReferencia = idReferencia;
    }

    public String getDefinicionTabla() {
        return definicionTabla;
    }

    public void setDefinicionTabla(String definicionTabla) {
        this.definicionTabla = definicionTabla;
    }

    public String getDefinicionCampo() {
        return definicionCampo;
    }

    public void setDefinicionCampo(String definicionCampo) {
        this.definicionCampo = definicionCampo;
    }

    public Migracion getIdMigracion() {
        return idMigracion;
    }

    public void setIdMigracion(Migracion idMigracion) {
        this.idMigracion = idMigracion;
    }
}
