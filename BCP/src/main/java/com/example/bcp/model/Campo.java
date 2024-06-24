package com.example.bcp.model;

import jakarta.persistence.*;
@Entity
@Table(name = "\"Campo\"")
public class Campo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"id_campo\"")
    private Integer campoId;
    @OneToOne
    @JoinColumn(name = "\"ID_Modelo\"", nullable = false)
    private Pedido modeloId;
    @ManyToOne
    @JoinColumn(name = "\"id_TipoDeDato\"", nullable = false)
    private TipoDato tipoDeDatoId;
    @Column(name = "\"valor\"", length = 100)
    private String valor;
    @Column(name = "\"propiedades\"", length = 250)
    private String propiedades;
    @ManyToOne
    @JoinColumn(name = "\"id_AlgoritmoEnc\"")
    private TipoDato algoritmoEncId;
    @ManyToOne
    @JoinColumn(name = "\"id_AlgoritmoEnm\"")
    private TipoDato algoritmoEnmId;

    public Campo(Integer campoId, Pedido modeloId, TipoDato tipoDeDatoId, String valor, String propiedades, TipoDato algoritmoEncId, TipoDato algoritmoEnmId) {
        this.campoId = campoId;
        this.modeloId = modeloId;
        this.tipoDeDatoId = tipoDeDatoId;
        this.valor = valor;
        this.propiedades = propiedades;
        this.algoritmoEncId = algoritmoEncId;
        this.algoritmoEnmId = algoritmoEnmId;
    }

    public Campo() {
    }

    public Integer getCampoId() {
        return campoId;
    }

    public void setCampoId(Integer campoId) {
        this.campoId = campoId;
    }

    public Pedido getModeloId() {
        return modeloId;
    }

    public void setModeloId(Pedido modeloId) {
        this.modeloId = modeloId;
    }

    public TipoDato getTipoDeDatoId() {
        return tipoDeDatoId;
    }

    public void setTipoDeDatoId(TipoDato tipoDeDatoId) {
        this.tipoDeDatoId = tipoDeDatoId;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(String propiedades) {
        this.propiedades = propiedades;
    }

    public TipoDato getAlgoritmoEncId() {
        return algoritmoEncId;
    }

    public void setAlgoritmoEncId(TipoDato algoritmoEncId) {
        this.algoritmoEncId = algoritmoEncId;
    }

    public TipoDato getAlgoritmoEnmId() {
        return algoritmoEnmId;
    }

    public void setAlgoritmoEnmId(TipoDato algoritmoEnmId) {
        this.algoritmoEnmId = algoritmoEnmId;
    }
}
