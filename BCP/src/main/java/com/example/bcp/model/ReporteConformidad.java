package com.example.bcp.model;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;


@Entity
@Table(name = "\"Reporte_Conformidad\"")
public class ReporteConformidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"Reporte_Id\"")
    private Integer reporteId;

    @ManyToOne
    @JoinColumn(name = "\"Pedido_Id\"", nullable = false)
    private Pedido pedidoId;

    @Column(name = "\"Estado\"")
    private String estado;

    @Column(name = "\"Tipo_Reporte\"")
    private String tipoReporte;

    @Column(name = "\"Fecha\"")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @OneToMany(mappedBy = "reporteId")
    private List<ReunionReporteConformidad> reuniones;

    public ReporteConformidad() {
    }

    public ReporteConformidad(Integer reporteId, Pedido pedidoId, String estado, String tipoReporte, Date fecha, List<ReunionReporteConformidad> reuniones) {
        this.reporteId = reporteId;
        this.pedidoId = pedidoId;
        this.estado = estado;
        this.tipoReporte = tipoReporte;
        this.fecha = fecha;
        this.reuniones = reuniones;
    }

    public Integer getReporteId() {
        return reporteId;
    }

    public void setReporteId(Integer reporteId) {
        this.reporteId = reporteId;
    }

    public Pedido getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Pedido pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoReporte() {
        return tipoReporte;
    }

    public void setTipoReporte(String tipoReporte) {
        this.tipoReporte = tipoReporte;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<ReunionReporteConformidad> getReuniones() {
        return reuniones;
    }

    public void setReuniones(List<ReunionReporteConformidad> reuniones) {
        this.reuniones = reuniones;
    }
}
