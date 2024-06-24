package com.example.bcp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "\"TipoError\"")
public class TipoError {
    @Id
    @Column(name = "\"Id_error\"")
    private Integer errorId;
    @Column(name = "\"Nombre_error\"", length = 50)
    private String nombreError;
    @OneToMany(mappedBy = "errorId")
    private List<RegistroDeErrores> registroDeErrores;

    public TipoError(Integer errorId, String nombreError) {
        this.errorId = errorId;
        this.nombreError = nombreError;
    }

    public TipoError() {
    }

    public Integer getErrorId() {
        return errorId;
    }

    public void setErrorId(Integer errorId) {
        this.errorId = errorId;
    }

    public String getNombreError() {
        return nombreError;
    }

    public void setNombreError(String nombreError) {
        this.nombreError = nombreError;
    }
}
