package com.example.bcp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "\"Modelado\"")
public class Modelado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ID_Modelo\"")
    private Integer idModelo;

    @ManyToOne
    @JoinColumn(name = "\"id_referencia\"")
    private DefinicionesTecnicas idReferencia;

    @Column(name = "\"EsquemaDDV\"")
    private String esquemaDDV;

    @Column(name = "\"CampoDDV\"")
    private String campoDDV;

    @Column(name = "\"CampoLlave\"")
    private Boolean campoLlave;

    @Column(name = "\"Campo_Descarta\"")
    private Boolean campoDescarta;

    public Integer getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Integer idModelo) {
        this.idModelo = idModelo;
    }

    public DefinicionesTecnicas getIdReferencia() {
        return idReferencia;
    }

    public void setIdReferencia(DefinicionesTecnicas idReferencia) {
        this.idReferencia = idReferencia;
    }

    public String getEsquemaDDV() {
        return esquemaDDV;
    }

    public void setEsquemaDDV(String esquemaDDV) {
        this.esquemaDDV = esquemaDDV;
    }

    public String getCampoDDV() {
        return campoDDV;
    }

    public void setCampoDDV(String campoDDV) {
        this.campoDDV = campoDDV;
    }

    public Boolean getCampoLlave() {
        return campoLlave;
    }

    public void setCampoLlave(Boolean campoLlave) {
        this.campoLlave = campoLlave;
    }

    public Boolean getCampoDescarta() {
        return campoDescarta;
    }

    public void setCampoDescarta(Boolean campoDescarta) {
        this.campoDescarta = campoDescarta;
    }
}
