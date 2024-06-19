package com.example.bcp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "\"Reunion_Reporte_Conformidad\"")
public class ReunionReporteConformidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"Id_Reu_Rep\"")
    private Integer idReuRep;

    @ManyToOne
    @JoinColumn(name = "\"Reunion_Id\"")
    private Reunion reunionId;

    @ManyToOne
    @JoinColumn(name = "\"Reporte_Id\"")
    private ReporteConformidad reporteId;


    public ReunionReporteConformidad() {
        super();
    }

    public ReunionReporteConformidad(Integer idReuRep, Reunion reunionId, ReporteConformidad reporteId) {
        super();
        this.idReuRep = idReuRep;
        this.reunionId = reunionId;
        this.reporteId = reporteId;
    }

    public Integer getIdReuRep() {
        return idReuRep;
    }

    public void setIdReuRep(Integer idReuRep) {
        this.idReuRep = idReuRep;
    }

    public Reunion getReunionId() {
        return reunionId;
    }

    public void setReunionId(Reunion reunionId) {
        this.reunionId = reunionId;
    }

    public ReporteConformidad getReporteId() {
        return reporteId;
    }

    public void setReporteId(ReporteConformidad reporteId) {
        this.reporteId = reporteId;
    }


}
