package com.example.bcp.model;

import jakarta.persistence.*;

@Entity
@Table( name = "\"Recordatorio_Enviado\"")
public class RecordatorioEnviado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column ( name = "\"Id_RecordatorioEnviado\"")
    private Integer idRecordatorioEnviado;

    @ManyToOne
    @JoinColumn(name = "\"recordatorio_id\"", nullable = false)
    private Recordatorio recordatorioId;

    @ManyToOne
    @JoinColumn(name = "\"participante_id\"", nullable = false)
    private Participante participanteId;

    public RecordatorioEnviado() {
    }

    public RecordatorioEnviado(Integer idRecordatorioEnviado, Recordatorio recordatorioId, Participante participanteId) {
        this.idRecordatorioEnviado = idRecordatorioEnviado;
        this.recordatorioId = recordatorioId;
        this.participanteId = participanteId;
    }

    public Integer getIdRecordatorioEnviado() {
        return idRecordatorioEnviado;
    }

    public void setIdRecordatorioEnviado(Integer idRecordatorioEnviado) {
        this.idRecordatorioEnviado = idRecordatorioEnviado;
    }

    public Recordatorio getRecordatorioId() {
        return recordatorioId;
    }

    public void setRecordatorioId(Recordatorio recordatorioId) {
        this.recordatorioId = recordatorioId;
    }

    public Participante getParticipanteId() {
        return participanteId;
    }

    public void setParticipanteId(Participante participanteId) {
        this.participanteId = participanteId;
    }
}