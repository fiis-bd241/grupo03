package com.example.bcp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "\"Squad\"")
public class Squad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"id_squad\"")
    private Integer idSquad;

    @Column(name = "\"nombre_squad\"", length = 50)
    private String nombreSquad;

    // Getters and Setters
    public Integer getIdSquad() {
        return idSquad;
    }

    public void setIdSquad(Integer idSquad) {
        this.idSquad = idSquad;
    }

    public String getNombreSquad() {
        return nombreSquad;
    }

    public void setNombreSquad(String nombreSquad) {
        this.nombreSquad = nombreSquad;
    }
}
