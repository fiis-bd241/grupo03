package com.example.bcp.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "\"Reunion\"")
public class Reunion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"Reunion_Id\"")
    private Integer reunionId;

    @ManyToOne
    @JoinColumn(name = "\"Id_Empleado\"")
    private Empleado idEmpleado;

    @ManyToOne
    @JoinColumn(name = "\"Pedido_Id\"")
    private Pedido pedidoId;

    @ManyToOne
    @JoinColumn(name = "\"TipoReunion_Id\"")
    private TipoReunion tipoReunionId;

    @Column(name = "\"HoraInicio\"")
    @Temporal(TemporalType.TIME)
    private Date horaInicio;

    @Column(name = "\"HoraFin\"")
    @Temporal(TemporalType.TIME)
    private Date horaFin;

    @Column(name = "\"Plataforma\"")
    private String plataforma;

    @Column(name = "\"Fecha\"")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(name = "\"Estado\"")
    private String estado;

    @Column(name = "\"Agenda\"")
    private String agenda;

    @Column(name = "\"Acuerdos\"")
    private String acuerdos;

    @Column(name = "\"HoraProgramacion\"")
    @Temporal(TemporalType.TIME)
    private Date horaProgramacion;

    @Column(name = "\"FechaProgramacion\"")
    @Temporal(TemporalType.DATE)
    private Date fechaProgramacion;


    @OneToMany(mappedBy = "reunionId")
    private List<ParticipaEn> participantes;

    @OneToMany(mappedBy = "reunionId")
    private List<Recordatorio> recordatorios;

    @OneToMany(mappedBy = "reunionId")
    private List<ReunionReporteConformidad> reportes;

    public Reunion() {
    }

    public Reunion(Integer reunionId, Empleado idEmpleado, Pedido pedidoId, TipoReunion tipoReunionId, Date horaInicio, Date horaFin, String plataforma, Date fecha, String estado, String agenda, String acuerdos, Date horaProgramacion, Date fechaProgramacion, List<ParticipaEn> participantes, List<Recordatorio> recordatorios, List<ReunionReporteConformidad> reportes) {
        this.reunionId = reunionId;
        this.idEmpleado = idEmpleado;
        this.pedidoId = pedidoId;
        this.tipoReunionId = tipoReunionId;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.plataforma = plataforma;
        this.fecha = fecha;
        this.estado = estado;
        this.agenda = agenda;
        this.acuerdos = acuerdos;
        this.horaProgramacion = horaProgramacion;
        this.fechaProgramacion = fechaProgramacion;
        this.participantes = participantes;
        this.recordatorios = recordatorios;
        this.reportes = reportes;
    }

    public Integer getReunionId() {
        return reunionId;
    }

    public void setReunionId(Integer reunionId) {
        this.reunionId = reunionId;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Pedido getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Pedido pedidoId) {
        this.pedidoId = pedidoId;
    }

    public TipoReunion getTipoReunionId() {
        return tipoReunionId;
    }

    public void setTipoReunionId(TipoReunion tipoReunionId) {
        this.tipoReunionId = tipoReunionId;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }

    public String getAcuerdos() {
        return acuerdos;
    }

    public void setAcuerdos(String acuerdos) {
        this.acuerdos = acuerdos;
    }

    public Date getHoraProgramacion() {
        return horaProgramacion;
    }

    public void setHoraProgramacion(Date horaProgramacion) {
        this.horaProgramacion = horaProgramacion;
    }

    public Date getFechaProgramacion() {
        return fechaProgramacion;
    }

    public void setFechaProgramacion(Date fechaProgramacion) {
        this.fechaProgramacion = fechaProgramacion;
    }

    public List<ParticipaEn> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<ParticipaEn> participantes) {
        this.participantes = participantes;
    }

    public List<Recordatorio> getRecordatorios() {
        return recordatorios;
    }

    public void setRecordatorios(List<Recordatorio> recordatorios) {
        this.recordatorios = recordatorios;
    }

    public List<ReunionReporteConformidad> getReportes() {
        return reportes;
    }

    public void setReportes(List<ReunionReporteConformidad> reportes) {
        this.reportes = reportes;
    }
}