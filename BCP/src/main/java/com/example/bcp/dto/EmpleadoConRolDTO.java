package com.example.bcp.dto;

public class EmpleadoConRolDTO {
    private Integer idEmpleado;
    private String dni;
    private String nombre;
    private String rol;
    private String contrasena;
    private String correo;
    private String telefono;

    public EmpleadoConRolDTO(Integer idEmpleado, String dni, String nombre, String rol, String contrasena, String correo, String telefono) {
        this.idEmpleado = idEmpleado;
        this.dni = dni;
        this.nombre = nombre;
        this.rol = rol;
        this.contrasena = contrasena;
        this.correo = correo;
        this.telefono = telefono;
    }

    // Getters y setters

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}

