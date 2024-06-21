package com.example.bcp.model;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "\"Universo\"")
public class Universo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ID_Universo\"")
    private Integer universoId;

    @OneToOne
    @JoinColumn(name = "\"Pedido_Id\"", nullable = false)
    private Pedido pedidoId;

    @Column(name = "\"Codigo\"")
    private String codigo;

    @Column(name = "\"Fecha_Creacion\"")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;

    public Universo() {
    }
    public Universo(Integer universoId, Pedido pedidoId, String codigo, Date fechaCreacion) {
        this.universoId = universoId;
        this.pedidoId = pedidoId;
        this.codigo = codigo;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getUniversoId() {
        return universoId;
    }

    public Pedido getPedidoId() {
        return pedidoId;
    }

    public String getCodigo() {
        return codigo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setUniversoId(Integer universoId) {
        this.universoId = universoId;
    }

    public void setPedidoId(Pedido pedidoId) {
        this.pedidoId = pedidoId;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

}
