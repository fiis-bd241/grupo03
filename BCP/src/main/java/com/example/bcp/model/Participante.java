package com.example.bcp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "\"Participante\"")
public class Participante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"Participante_Id\"")
    private Integer participanteId;

    @Column(name = "\"Area_Id\"", nullable = false)
    private Integer areaId;

    @Column(name = "\"Nombre\"")
    private String nombre;

    @Column(name = "\"Apellido\"")
    private String apellido;

    @Column(name = "\"Correo\"")
    private String correo;

    @OneToMany(mappedBy = "participanteId")
    private List<ParticipaEn> reuniones ;

    @OneToMany(mappedBy = "participanteId")
    private List<RecordatorioEnviado> recordatoriosEnviados ;

    public Participante() {
    }

    public Participante(Integer participanteId, Integer areaId, String nombre, String apellido, String correo, List<ParticipaEn> reuniones, List<RecordatorioEnviado> recordatoriosEnviados) {
        this.participanteId = participanteId;
        this.areaId = areaId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.reuniones = reuniones;
        this.recordatoriosEnviados = recordatoriosEnviados;
    }

    public Integer getParticipanteId() {
        return participanteId;
    }

    public void setParticipanteId(Integer participanteId) {
        this.participanteId = participanteId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<ParticipaEn> getReuniones() {
        return reuniones;
    }

    public void setReuniones(List<ParticipaEn> reuniones) {
        this.reuniones = reuniones;
    }

    public List<RecordatorioEnviado> getRecordatoriosEnviados() {
        return recordatoriosEnviados;
    }

    public void setRecordatoriosEnviados(List<RecordatorioEnviado> recordatoriosEnviados) {
        this.recordatoriosEnviados = recordatoriosEnviados;
    }
}