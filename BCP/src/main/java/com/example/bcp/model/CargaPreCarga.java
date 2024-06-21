package com.example.bcp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "\"CargaPreCarga\"")
public class CargaPreCarga {
    @Id
    @Column(name = "\"ID_CargaPrecarga\"")
    private Integer cargaprecargaId;
    @ManyToOne
    @JoinColumn(name = "\"ID_ReglaCarga\"", nullable = false)
    private ReglaDeCargaTecnica reglacargaId;
    @ManyToOne
    @JoinColumn(name = "\"ID_Precarga\"", nullable = false)
    private PreCarga precargaId;
}
