package com.example.bcp.rest;

import com.example.bcp.dto.EmpleadoConRolDTO;
import com.example.bcp.model.Empleado;
import com.example.bcp.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/empleado/")
public class EmpleadoRest {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/PO")
    public List<String> todosProductOwner() {
        return empleadoService.todosProductOwner();
    }

    @GetMapping("/todos")
    public List<EmpleadoConRolDTO> obtenerTodosLosEmpleados() {
        return empleadoService.obtenerTodosLosEmpleados();
    }
}
