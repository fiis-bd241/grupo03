package com.example.bcp.model;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Notificacion")
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Notifcacion_Id")
    private Integer notificacionId;

    @ManyToOne
    @JoinColumn(name = "Pedido_Id", nullable = false)
    private Pedido pedidoId;

    @ManyToOne
    @JoinColumn(name = "Squad_Id", nullable = false)
    private Squad squadId;

    @Column(name = "Notificacion_Fecha")
    @Temporal(TemporalType.DATE)
    private Date notificacionFecha;

    @Column(name = "Notificacion_Hora")
    @Temporal(TemporalType.TIME)
    private Date notificacionHora;

    @Column(name = "Notificacion_Asunto", length = 50)
    private String notificacionAsunto;

    @Column(name = "Notificacion_Contenido", length = 250)
    private String notificacionContenido;

    // Getters and Setters
    public Integer getNotificacionId() {
        return notificacionId;
    }

    public void setNotificacionId(Integer notificacionId) {
        this.notificacionId = notificacionId;
    }

    public Pedido getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Pedido pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Squad getSquadId() {
        return squadId;
    }

    public void setSquadId(Squad squadId) {
        this.squadId = squadId;
    }

    public Date getNotificacionFecha() {
        return notificacionFecha;
    }

    public void setNotificacionFecha(Date notificacionFecha) {
        this.notificacionFecha = notificacionFecha;
    }

    public Date getNotificacionHora() {
        return notificacionHora;
    }

    public void setNotificacionHora(Date notificacionHora) {
        this.notificacionHora = notificacionHora;
    }

    public String getNotificacionAsunto() {
        return notificacionAsunto;
    }

    public void setNotificacionAsunto(String notificacionAsunto) {
        this.notificacionAsunto = notificacionAsunto;
    }

    public String getNotificacionContenido() {
        return notificacionContenido;
    }

    public void setNotificacionContenido(String notificacionContenido) {
        this.notificacionContenido = notificacionContenido;
    }

    public Notificacion() {
    }

    public Notificacion(Pedido pedidoId, Squad squadId, Date notificacionFecha, Date notificacionHora, String notificacionAsunto, String notificacionContenido) {
        this.pedidoId = pedidoId;
        this.squadId = squadId;
        this.notificacionFecha = notificacionFecha;
        this.notificacionHora = notificacionHora;
        this.notificacionAsunto = notificacionAsunto;
        this.notificacionContenido = notificacionContenido;
    }
}

