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
    private String contrasena;

    @Column(name = "\"telefono\"")
    private String telefono;

    @Column(name = "\"dni\"")
    private String dni;

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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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
}
