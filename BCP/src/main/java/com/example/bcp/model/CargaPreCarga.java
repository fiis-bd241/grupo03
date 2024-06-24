package com.example.bcp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "\"CargaPreCarga\"")
public class CargaPreCarga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ID_CargaPrecarga\"")
    private Integer cargaprecargaId;
    @ManyToOne
    @JoinColumn(name = "\"ID_ReglaCarga\"", nullable = false)
    private ReglaDeCargaTecnica reglacargaId;
    @ManyToOne
    @JoinColumn(name = "\"ID_Precarga\"", nullable = false)
    private PreCarga precargaId;

    public CargaPreCarga(Integer cargaprecargaId, ReglaDeCargaTecnica reglacargaId, PreCarga precargaId) {
        this.cargaprecargaId = cargaprecargaId;
        this.reglacargaId = reglacargaId;
        this.precargaId = precargaId;
    }

    public CargaPreCarga() {
    }

    public Integer getCargaprecargaId() {
        return cargaprecargaId;
    }

    public void setCargaprecargaId(Integer cargaprecargaId) {
        this.cargaprecargaId = cargaprecargaId;
    }

    public ReglaDeCargaTecnica getReglacargaId() {
        return reglacargaId;
    }

    public void setReglacargaId(ReglaDeCargaTecnica reglacargaId) {
        this.reglacargaId = reglacargaId;
    }

    public PreCarga getPrecargaId() {
        return precargaId;
    }

    public void setPrecargaId(PreCarga precargaId) {
        this.precargaId = precargaId;
    }
}
