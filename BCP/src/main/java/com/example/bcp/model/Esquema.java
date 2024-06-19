package com.example.bcp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "\"Esquema\"")
public class Esquema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"id_esquema\"")
    private Integer idEsquema;

    @Column(name="\"nombre_esquema\"")
    private String nombreEsquema;

    @ManyToOne
    @JoinColumn(name = "\"AmbienteId\"")
    private Ambiente idAmbiente;

    public Integer getIdEsquema() {
        return idEsquema;
    }

    public void setIdEsquema(Integer idEsquema) {
        this.idEsquema = idEsquema;
    }

    public String getNombreEsquema() {
        return nombreEsquema;
    }

    public void setNombreEsquema(String nombreEsquema) {
        this.nombreEsquema = nombreEsquema;
    }

    public Ambiente getIdAmbiente() {
        return idAmbiente;
    }

    public void setIdAmbiente(Ambiente idAmbiente) {
        this.idAmbiente = idAmbiente;
    }
}
