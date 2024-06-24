package com.example.bcp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"Algoritmo\"")
public class Algoritmo {
    @Id
    @Column(name = "\"id_algoritmo\"")
    private Integer algoritmoId;
    @Column(name = "\"nombre_algoritmo\"", length = 200)
    private String nombreAlgoritmo;
    @Column(name = "\"descripcion\"")
    private String descripcion;
    @Column(name = "\"longClave\"", length = 200)
    private String longClave;
    @Column(name = "\"tipo\"", length = 200)
    private String tipo;

    public Algoritmo(Integer algoritmoId, String nombreAlgoritmo, String descripcion, String longClave, String tipo) {
        this.algoritmoId = algoritmoId;
        this.nombreAlgoritmo = nombreAlgoritmo;
        this.descripcion = descripcion;
        this.longClave = longClave;
        this.tipo = tipo;
    }

    public Algoritmo() {
    }

    public Integer getAlgoritmoId() {
        return algoritmoId;
    }

    public void setAlgoritmoId(Integer algoritmoId) {
        this.algoritmoId = algoritmoId;
    }

    public String getNombreAlgoritmo() {
        return nombreAlgoritmo;
    }

    public void setNombreAlgoritmo(String nombreAlgoritmo) {
        this.nombreAlgoritmo = nombreAlgoritmo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLongClave() {
        return longClave;
    }

    public void setLongClave(String longClave) {
        this.longClave = longClave;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
