package com.example.bcp.rest;

import com.example.bcp.model.Empleado;
import com.example.bcp.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String dni, @RequestParam String contrasena) {
        Empleado empleado = authService.login(dni, contrasena);
        if (empleado != null) {
            return ResponseEntity.ok(empleado);
        } else {
            return ResponseEntity.status(401).body("Credenciales incorrectas");
        }
    }
}
