package com.example.bcp.model;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "\"Tarea\"")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"id_tarea\"")
    private Integer idTarea;

    @ManyToOne
    @JoinColumn(name = "\"id_empleado\"")
    private Empleado idEmpleado;

    @ManyToOne
    @JoinColumn(name = "\"id_migracion\"")
    private Migracion idMigracion;

    @Column(name = "\"descripcion\"")
    private String descripcion;

    @Column(name = "\"fecha_fin\"")
    private Date fechaFin;

    @Column(name = "\"fecha_inicio\"")
    private Date fechaInicio;

    @Column(name = "\"fecha_fin_real\"")
    private Date fechaFinReal;

    @Column(name = "\"calidad\"")
    private int calidad;

    @ManyToOne
    @JoinColumn(name = "\"estadoId\"")
    private Estado idEstado;

    public Integer getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Integer idTarea) {
        this.idTarea = idTarea;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Migracion getIdMigracion() {
        return idMigracion;
    }

    public void setIdMigracion(Migracion idMigracion) {
        this.idMigracion = idMigracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinReal() {
        return fechaFinReal;
    }

    public void setFechaFinReal(Date fechaFinReal) {
        this.fechaFinReal = fechaFinReal;
    }

    public int getCalidad() {
        return calidad;
    }

    public void setCalidad(int calidad) {
        this.calidad = calidad;
    }

    public Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estado idEstado) {
        this.idEstado = idEstado;
    }
}
