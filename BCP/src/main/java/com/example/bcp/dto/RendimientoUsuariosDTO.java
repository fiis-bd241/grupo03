package com.example.bcp.dto;

import java.util.Date;

public class RendimientoUsuariosDTO {

    private Integer idEmpleado;
    private String empleado;
    private String rol;
    private Date fecha;
    private Long tareasCompletadas;
    private Integer tiempoPromedio;
    private Integer calidadTrabajo;
    private Long participacionReuniones;

    // Constructor
    public RendimientoUsuariosDTO(Integer idEmpleado, String empleado, String rol, Date fecha,
                                  Long tareasCompletadas, Integer tiempoPromedio,
                                  Integer calidadTrabajo, Long participacionReuniones) {
        this.idEmpleado = idEmpleado;
        this.empleado = empleado;
        this.rol = rol;
        this.fecha = fecha;
        this.tareasCompletadas = tareasCompletadas;
        this.tiempoPromedio = tiempoPromedio;
        this.calidadTrabajo = calidadTrabajo;
        this.participacionReuniones = participacionReuniones;
    }

    // Getters y Setters
    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getTareasCompletadas() {
        return tareasCompletadas;
    }

    public void setTareasCompletadas(Long tareasCompletadas) {
        this.tareasCompletadas = tareasCompletadas;
    }

    public Integer getTiempoPromedio() {
        return tiempoPromedio;
    }

    public void setTiempoPromedio(Integer tiempoPromedio) {
        this.tiempoPromedio = tiempoPromedio;
    }

    public Integer getCalidadTrabajo() {
        return calidadTrabajo;
    }

    public void setCalidadTrabajo(Integer calidadTrabajo) {
        this.calidadTrabajo = calidadTrabajo;
    }

    public Long getParticipacionReuniones() {
        return participacionReuniones;
    }

    public void setParticipacionReuniones(Long participacionReuniones) {
        this.participacionReuniones = participacionReuniones;
    }
}
