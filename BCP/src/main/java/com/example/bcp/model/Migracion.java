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
    private Squad idSquad;

    @ManyToOne
    @JoinColumn(name = "\"Id_tecnologia\"", nullable = false)
    private Tecnologia idTecnologia;

    @Column(name = "\"Entorno\"", length = 50)
    private String entorno;

    @Column(name = "\"Fecha_migracion\"")
    @Temporal(TemporalType.DATE)
    private Date fechaMigracion;

    @Column(name = "\"Valido\"")
    private Boolean valido;

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

    public Squad getIdSquad() {
        return idSquad;
    }

    public void setIdSquad(Squad idSquad) {
        this.idSquad = idSquad;
    }

    public Tecnologia getIdTecnologia() {
        return idTecnologia;
    }

    public void setIdTecnologia(Tecnologia idTecnologia) {
        this.idTecnologia = idTecnologia;
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

    public Migracion() {
        // Constructor por defecto
    }

    public Migracion(Pedido pedidoId, Squad idSquad, Tecnologia idTecnologia, String entorno, Date fechaMigracion, Boolean valido) {
        this.pedidoId = pedidoId;
        this.idSquad = idSquad;
        this.idTecnologia = idTecnologia;
        this.entorno = entorno;
        this.fechaMigracion = fechaMigracion;
        this.valido = valido;
    }
}
