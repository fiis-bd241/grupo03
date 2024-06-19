package com.example.bcp.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "\"Migracion\"")
public class Migracion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"Migracion_Id\"")
    private Integer migracionId;

    @ManyToOne
    @JoinColumn(name = "\"Pedido_Id\"", nullable = false)
    private Pedido pedidoId;

    @ManyToOne
    @JoinColumn(name = "\"Id_Squad\"", nullable = false)
    private Squad SquadId;

    @ManyToOne
    @JoinColumn(name = "\"Id_Tecnologia\"", nullable = false)
    private Tecnologia TecnologiaId;

    @Column(name = "\"Entorno\"", length = 50)
    private String entorno;

    @Column(name = "\"Fecha_migracion\"")
    @Temporal(TemporalType.DATE)
    private Date fechaMigracion;

    @Column(name = "\"Valido\"")
    private Boolean valido;

    @Column(name = "\"Ultimo\"")
    private Boolean ultimo;

    public Migracion() {

    }

    // Getters and Setters

    public Integer getMigracionId() {
        return migracionId;
    }

    public void setMigracionId(Integer migracionId) {
        this.migracionId = migracionId;
    }

    public Pedido getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Pedido pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Squad getSquadId() {
        return SquadId;
    }

    public void setSquadId(Squad SquadId) {
        this.SquadId = SquadId;
    }

    public Tecnologia getTecnologiaId() {
        return TecnologiaId;
    }

    public void setTecnologiaId(Tecnologia TecnologiaId) {
        this.TecnologiaId = TecnologiaId;
    }

    public String getEntorno() {
        return entorno;
    }

    public void setEntorno(String entorno) {
        this.entorno = entorno;
    }

    public Date getFechaMigracion() {
        return fechaMigracion;
    }

    public void setFechaMigracion(Date fechaMigracion) {
        this.fechaMigracion = fechaMigracion;
    }

    public Boolean getValido() {
        return valido;
    }

    public void setValido(Boolean valido) {
        this.valido = valido;
    }

    public Boolean getUltimo() {
        return ultimo;
    }

    public void setUltimo(Boolean ultimo) {
        this.ultimo = ultimo;
    }

    public Migracion(Boolean ultimo) {
        // Constructor por defecto
        this.ultimo = ultimo;
    }

    public Migracion(Pedido pedidoId, Squad idSquad, Tecnologia idTecnologia, String entorno, Date fechaMigracion, Boolean valido, Boolean ultimo) {
        this.pedidoId = pedidoId;
        this.SquadId = idSquad;
        this.TecnologiaId = idTecnologia;
        this.entorno = entorno;
        this.fechaMigracion = fechaMigracion;
        this.valido = valido;
        this.ultimo = ultimo;
    }
}
