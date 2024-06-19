package com.example.bcp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "\"Squad\"")
public class Squad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"id_squad\"")
    private Integer SquadId;

    @Column(name = "\"nombre_squad\"", length = 50)
    private String nombreSquad;

    // Getters and Setters
    public Integer getSquadId() {
        return SquadId;
    }

    public void setSquadId(Integer idSquad) {
        this.SquadId = idSquad;
    }

    public String getNombreSquad() {
        return nombreSquad;
    }

    public void setNombreSquad(String nombreSquad) {
        this.nombreSquad = nombreSquad;
    }
}
