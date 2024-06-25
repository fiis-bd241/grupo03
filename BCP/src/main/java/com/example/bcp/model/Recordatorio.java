package com.example.bcp.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "\"Recordatorio\"")
public class Recordatorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"Recordatorio_Id\"")
    private Integer recordatorioId;


    @ManyToOne
    @JoinColumn(name = "\"Reunion_Id\"")
    private Reunion reunionId;

    @ManyToOne
    @JoinColumn(name = "\"TipoRecordatorio_Id\"")
    private TipoRecordatorio tipoRecordatorioId;

    @Column(name = "\"Hora\"")
    private LocalTime hora;

    @Column(name = "\"Fecha\"")
    @Temporal(TemporalType.DATE)
    private LocalDate fecha;

    @OneToMany(mappedBy = "recordatorioId")
    private List<RecordatorioEnviado> participantes ;

    public Recordatorio() {
    }

    public Recordatorio(Integer recordatorioId, Reunion reunionId, TipoRecordatorio tipoRecordatorioId, LocalTime hora, LocalDate fecha, List<RecordatorioEnviado> participantes) {
        this.recordatorioId = recordatorioId;
        this.reunionId = reunionId;
        this.tipoRecordatorioId = tipoRecordatorioId;
        this.hora = hora;
        this.fecha = fecha;
        this.participantes = participantes;
    }

    public Integer getRecordatorioId() {
        return recordatorioId;
    }

    public void setRecordatorioId(Integer recordatorioId) {
        this.recordatorioId = recordatorioId;
    }

    public Reunion getReunionId() {
        return reunionId;
    }

    public void setReunionId(Reunion reunionId) {
        this.reunionId = reunionId;
    }

    public TipoRecordatorio getTipoRecordatorioId() {
        return tipoRecordatorioId;
    }

    public void setTipoRecordatorioId(TipoRecordatorio tipoRecordatorioId) {
        this.tipoRecordatorioId = tipoRecordatorioId;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<RecordatorioEnviado> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<RecordatorioEnviado> participantes) {
        this.participantes = participantes;
    }
}
