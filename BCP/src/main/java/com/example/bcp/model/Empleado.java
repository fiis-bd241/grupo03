package com.example.bcp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "\"Empleado\"")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"id_empleado\"")
    private Integer idEmpleado;

    @Column(name = "\"nombre\"")
    private String nombre;

    @Column(name = "\"correo\"")
    private String correo;

    @Column(name = "\"contraseña\"")
    private String contraseña;

    @Column(name = "\"telefono\"")
    private String telefono;

    @Column(name = "\"dni\"")
    private String dni;

    @Column(name = "\"rol_id\"")
    private Integer rolId;


    // Constructor

    public Empleado(Integer idEmpleado

            , String nombre, String correo, String contraseña, String telefono, String dni,
                    Integer rolId) {
        super();
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.telefono = telefono;
        this.dni = dni;
        this.rolId = rolId;
    }

    public Empleado() {
        super();
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }
}
