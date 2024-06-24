package com.example.bcp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "\"PreCarga\"")
public class PreCarga {

    @Id
    @Column(name = "\"ID_Precarga\"")
    private Integer precargaId;

    @Column(name = "\"Nombre_Regla\"", length = 100)
    private String nombreRegla;

    @Column(name = "\"Descripcion\"", length = 200)
    private String descripcion;

    @Column(name = "\"Obligatorio\"")
    private Boolean obligatorio;

    public PreCarga(Integer precargaId, String nombreRegla, String descripcion, Boolean obligatorio) {
        this.precargaId = precargaId;
        this.nombreRegla = nombreRegla;
        this.descripcion = descripcion;
        this.obligatorio = obligatorio;
    }

    public PreCarga() {
    }

    public Integer getPrecargaId() {
        return precargaId;
    }

    public void setPrecargaId(Integer precargaId) {
        this.precargaId = precargaId;
    }

    public String getNombreRegla() {
        return nombreRegla;
    }

    public void setNombreRegla(String nombreRegla) {
        this.nombreRegla = nombreRegla;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getObligatorio() {
        return obligatorio;
    }

    public void setObligatorio(Boolean obligatorio) {
        this.obligatorio = obligatorio;
    }
}
