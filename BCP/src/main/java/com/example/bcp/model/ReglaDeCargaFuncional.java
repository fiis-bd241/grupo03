package com.example.bcp.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "\"ReglaDeCargaFuncional\"")
public class ReglaDeCargaFuncional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ID_ReglaCargaFunc\"")
    private Integer universoId;

    @OneToOne
    @JoinColumn(name = "\"id_migracion\"", nullable = false)
    private Migracion migracionId;

    @OneToOne
    @JoinColumn(name = "\"id_tecnologia\"", nullable = false)
    private Tecnologia tecnologiaId;
    @Column(name = "\"Logica\"")
    private String logica;
    @Column(name = "\"Fecha\"")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public ReglaDeCargaFuncional(Integer universoId, Migracion migracionId, Tecnologia tecnologiaId, String logica, Date fecha) {
        this.universoId = universoId;
        this.migracionId = migracionId;
        this.tecnologiaId = tecnologiaId;
        this.logica = logica;
        this.fecha = fecha;
    }

    public ReglaDeCargaFuncional() {
    }

    public Integer getUniversoId() {
        return universoId;
    }

    public void setUniversoId(Integer universoId) {
        this.universoId = universoId;
    }

    public Migracion getMigracionId() {
        return migracionId;
    }

    public void setMigracionId(Migracion migracionId) {
        this.migracionId = migracionId;
    }

    public Tecnologia getTecnologiaId() {
        return tecnologiaId;
    }

    public void setTecnologiaId(Tecnologia tecnologiaId) {
        this.tecnologiaId = tecnologiaId;
    }

    public String getLogica() {
        return logica;
    }

    public void setLogica(String logica) {
        this.logica = logica;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
