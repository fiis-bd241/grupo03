package com.example.bcp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "\"Participa_en\"")
public class ParticipaEn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"Id_Participa_en\"")
    private Integer idParticipaEn;

    @ManyToOne
    @JoinColumn(name = "\"Reunion_Id\"", nullable = false)
    private Reunion reunionId;

    @ManyToOne
    @JoinColumn(name = "\"Participante_Id\"", nullable = false)
    private Participante participanteId;

    public ParticipaEn() {
    }

    public ParticipaEn(Integer idParticipaEn, Reunion reunionId, Participante participanteId) {
        this.idParticipaEn = idParticipaEn;
        this.reunionId = reunionId;
        this.participanteId = participanteId;
    }

    public Integer getIdParticipaEn() {
        return idParticipaEn;
    }

    public void setIdParticipaEn(Integer idParticipaEn) {
        this.idParticipaEn = idParticipaEn;
    }

    public Reunion getReunionId() {
        return reunionId;
    }

    public void setReunionId(Reunion reunionId) {
        this.reunionId = reunionId;
    }

    public Participante getParticipanteId() {
        return participanteId;
    }

    public void setParticipanteId(Participante participanteId) {
        this.participanteId = participanteId;
    }
}
