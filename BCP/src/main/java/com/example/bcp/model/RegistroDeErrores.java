package com.example.bcp.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "\"RegistroDeErrores\"")
public class RegistroDeErrores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"Id_registro_errores\"")
    private Integer registroErroresId;
    @OneToOne
    @JoinColumn(name = "\"Migracion_Id\"", nullable = false)
    private Migracion migracionId;
    @ManyToOne
    @JoinColumn(name = "\"Id_error\"", nullable = false)
    private TipoError errorId;
    @OneToOne
    @JoinColumn(name = "\"Id_Empleado\"", nullable = false)
    private Empleado empleado;
    @Column(name = "\"Correcion_error\"", length = 50)
    private String correccionError;
    @Column(name = "\"Fecha_registro\"")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Column(name = "\"Causa_error\"", length = 50)
    private String causaError;

    public RegistroDeErrores() {
    }

    public RegistroDeErrores(Integer registroErroresId, Migracion migracionId, TipoError errorId, Empleado empleado, String correccionError, Date fechaRegistro, String causaError) {
        this.registroErroresId = registroErroresId;
        this.migracionId = migracionId;
        this.errorId = errorId;
        this.empleado = empleado;
        this.correccionError = correccionError;
        this.fechaRegistro = fechaRegistro;
        this.causaError = causaError;

    }

    public Integer getRegistroErroresId() {
        return registroErroresId;
    }

    public void setRegistroErroresId(Integer registroErroresId) {
        this.registroErroresId = registroErroresId;
    }

    public Migracion getMigracionId() {
        return migracionId;
    }

    public void setMigracionId(Migracion migracionId) {
        this.migracionId = migracionId;
    }

    public TipoError getErrorId() {
        return errorId;
    }

    public void setErrorId(TipoError errorId) {
        this.errorId = errorId;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getCorreccionError() {
        return correccionError;
    }

    public void setCorreccionError(String correccionError) {
        this.correccionError = correccionError;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getCausaError() {
        return causaError;
    }

    public void setCausaError(String causaError) {
        this.causaError = causaError;
    }
}
