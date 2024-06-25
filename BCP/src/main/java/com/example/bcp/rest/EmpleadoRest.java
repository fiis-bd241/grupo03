package com.example.bcp.rest;

import com.example.bcp.dto.EmpleadoConRolDTO;
import com.example.bcp.model.Empleado;
import com.example.bcp.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/empleado/")
public class EmpleadoRest {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/PO")
    public List<Object[]> todosProductOwner() {
        return empleadoService.todosProductOwner();
    }

    @GetMapping("/todos")
    public List<EmpleadoConRolDTO> obtenerTodosLosEmpleados() {
        return empleadoService.obtenerTodosLosEmpleados();
    }

    @PostMapping("/agregar-empleado")
    public void agregarEmpleado(@RequestBody Empleado empleado) {
        empleadoService.agregarEmpleado(empleado);
    }

    @PostMapping("/actualizar-contrasena")
    public void actualizarContrasena(@RequestBody Map<String, String> payload) {
        String nombre = payload.get("nombre");
        empleadoService.actualizarContrasena(nombre);
    }
}
