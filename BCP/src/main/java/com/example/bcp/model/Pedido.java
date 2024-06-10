package com.example.bcp.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "\"Pedido\"")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"Pedido_Id\"")
    private Integer pedidoId;

    @ManyToOne
    @JoinColumn(name = "\"Area_Id\"", nullable = false)
    private Area areaId;

    @ManyToOne
    @JoinColumn(name = "\"Prioridad_Id\"", nullable = false)
    private Prioridad prioridadId;

    @ManyToOne
    @JoinColumn(name = "\"Estado_Id\"", nullable = false)
    private Estado estadoId;

    @Column(name = "\"Pedido_Fecha\"")
    @Temporal(TemporalType.DATE)
    private Date pedidoFecha;

    @Column(name = "\"Pedido_FechaLimite\"")
    @Temporal(TemporalType.DATE)
    private Date pedidoFechaLimite;

    // Getters and Setters

    public Integer getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Integer pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Area getAreaId() {
        return areaId;
    }

    public void setAreaId(Area areaId) {
        this.areaId = areaId;
    }

    public Prioridad getPrioridadId() {
        return prioridadId;
    }

    public void setPrioridadId(Prioridad prioridadId) {
        this.prioridadId = prioridadId;
    }

    public Estado getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Estado estadoId) {
        this.estadoId = estadoId;
    }

    public Date getPedidoFecha() {
        return pedidoFecha;
    }

    public void setPedidoFecha(Date pedidoFecha) {
        this.pedidoFecha = pedidoFecha;
    }

    public Date getPedidoFechaLimite() {
        return pedidoFechaLimite;
    }

    public void setPedidoFechaLimite(Date pedidoFechaLimite) {
        this.pedidoFechaLimite = pedidoFechaLimite;
    }

    public Pedido() {
        // Constructor por defecto
    }

    public Pedido(Area areaId, Prioridad prioridadId, Estado estadoId, Date pedidoFecha, Date pedidoFechaLimite) {
        this.areaId = areaId;
        this.prioridadId = prioridadId;
        this.estadoId = estadoId;
        this.pedidoFecha = pedidoFecha;
        this.pedidoFechaLimite = pedidoFechaLimite;
    }
}
