package com.example.bcp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "\"DefinicionesTecnicas\"")
public class DefinicionesTecnicas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"id_DT\"")
    private Integer idDT;

    @ManyToOne
    @JoinColumn(name = "\"EquivalenciaId\"")
    private DefinicionesTecnicas idEquivalencia;

    @ManyToOne
    @JoinColumn(name = "\"EsquemaId\"")
    private Esquema idEsquema;

    @Column(name = "\"Tabla\"")
    private String tabla;

    @Column(name = "\"Campo\"")
    private String campo;

    public Integer getIdDT() {
        return idDT;
    }

    public void setIdDT(Integer idDT) {
        this.idDT = idDT;
    }

    public DefinicionesTecnicas getIdEquivalencia() {
        return idEquivalencia;
    }

    public void setIdEquivalencia(DefinicionesTecnicas idEquivalencia) {
        this.idEquivalencia = idEquivalencia;
    }

    public Esquema getIdEsquema() {
        return idEsquema;
    }

    public void setIdEsquema(Esquema idEsquema) {
        this.idEsquema = idEsquema;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }
}
