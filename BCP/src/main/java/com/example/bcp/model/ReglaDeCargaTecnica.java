package com.example.bcp.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "\"ReglaDeCargaTecnica\"")
public class ReglaDeCargaTecnica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ID_ReglaCargaTecn\"")
    private Integer universoId;

    @OneToOne
    @JoinColumn(name = "\"regla_funcional\"", nullable = false)
    private ReglaDeCargaFuncional reglaFuncional;

    @Column(name = "\"Codigo\"")
    private String codigo;
    @Column(name = "\"Finalizado\"")
    private Boolean finalizado;
    @Column(name = "\"Comentario\"")
    private String comentario;
    @Column(name = "\"Fecha\"")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public ReglaDeCargaTecnica(Integer universoId, ReglaDeCargaFuncional reglaFuncional, String codigo, Boolean finalizado, String comentario, Date fecha) {
        this.universoId = universoId;
        this.reglaFuncional = reglaFuncional;
        this.codigo = codigo;
        this.finalizado = finalizado;
        this.comentario = comentario;
        this.fecha = fecha;
    }

    public ReglaDeCargaTecnica() {
    }

    public Integer getUniversoId() {
        return universoId;
    }

    public void setUniversoId(Integer universoId) {
        this.universoId = universoId;
    }

    public ReglaDeCargaFuncional getReglaFuncional() {
        return reglaFuncional;
    }

    public void setReglaFuncional(ReglaDeCargaFuncional reglaFuncional) {
        this.reglaFuncional = reglaFuncional;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Boolean getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(Boolean finalizado) {
        this.finalizado = finalizado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
