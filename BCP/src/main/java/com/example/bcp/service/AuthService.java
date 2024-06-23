package com.example.bcp.service;

import com.example.bcp.model.Empleado;
import com.example.bcp.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public Empleado login(String dni, String contrasena) {
        return empleadoRepository.findByDniAndContrasena(dni, contrasena);
    }
}
