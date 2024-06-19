package com.example.bcp.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "\"Tipo_Recordatorio\"")
public class TipoRecordatorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"TipoRecordatorio_Id\"")
    private Integer tipoRecordatorioId;

    @Column(name = "\"Nombre\"")
    private String nombre;

    @Column(name = "\"Descripcion\"")
    private String descripcion;

    @Column(name = "\"Mensaje\"")
    private String mensaje;

    @OneToMany(mappedBy = "tipoRecordatorioId")
    private List<Recordatorio> recordatorioId;

    public TipoRecordatorio() {
        super();
    }

    public TipoRecordatorio(Integer tipoRecordatorioId, String nombre, String descripcion, String mensaje,
                            List<Recordatorio> recordatorioId) {
        super();
        this.tipoRecordatorioId = tipoRecordatorioId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.mensaje = mensaje;
        this.recordatorioId = recordatorioId;
    }

    public Integer getTipoRecordatorioId() {
        return tipoRecordatorioId;
    }

    public void setTipoRecordatorioId(Integer tipoRecordatorioId) {
        this.tipoRecordatorioId = tipoRecordatorioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<Recordatorio> getRecordatorioId() {
        return recordatorioId;
    }

    public void setRecordatorioId(List<Recordatorio> recordatorioId) {
        this.recordatorioId = recordatorioId;
    }


}
