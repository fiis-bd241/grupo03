package com.example.bcp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "\"Programacion\"")
public class Programacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"Programacion_Id\"")
    private Integer programacionId;
    @OneToOne
    @JoinColumn(name = "\"Migracion_Id\"", nullable = false)
    private Migracion migracionId;
    @Column(name = "\"FrecuenciaEjecucion\"")
    private String frecuenciaEjecucion;
    @Column(name = "\"DiaInicio\"", length = 50)
    private String diaInicio;
    @Column(name = "\"DiaFin\"", length = 50)
    private String diaFin;
    @Column(name = "\"ConsideracionFrecuencia\"", length = 50)
    private String consideracionFrecuencia;

    public Programacion(Integer programacionId, Migracion migracionId, String frecuenciaEjecucion, String diaInicio, String diaFin, String consideracionFrecuencia) {
        this.programacionId = programacionId;
        this.migracionId = migracionId;
        this.frecuenciaEjecucion = frecuenciaEjecucion;
        this.diaInicio = diaInicio;
        this.diaFin = diaFin;
        this.consideracionFrecuencia = consideracionFrecuencia;
    }

    public Programacion() {
    }

    public Integer getProgramacionId() {
        return programacionId;
    }

    public void setProgramacionId(Integer programacionId) {
        this.programacionId = programacionId;
    }

    public Migracion getMigracionId() {
        return migracionId;
    }

    public void setMigracionId(Migracion migracionId) {
        this.migracionId = migracionId;
    }

    public String getFrecuenciaEjecucion() {
        return frecuenciaEjecucion;
    }

    public void setFrecuenciaEjecucion(String frecuenciaEjecucion) {
        this.frecuenciaEjecucion = frecuenciaEjecucion;
    }

    public String getDiaInicio() {
        return diaInicio;
    }

    public void setDiaInicio(String diaInicio) {
        this.diaInicio = diaInicio;
    }

    public String getDiaFin() {
        return diaFin;
    }

    public void setDiaFin(String diaFin) {
        this.diaFin = diaFin;
    }

    public String getConsideracionFrecuencia() {
        return consideracionFrecuencia;
    }

    public void setConsideracionFrecuencia(String consideracionFrecuencia) {
        this.consideracionFrecuencia = consideracionFrecuencia;
    }
}
