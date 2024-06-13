package com.example.bcp.rest;

import com.example.bcp.model.Prioridad;
import com.example.bcp.service.PrioridadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prioridad/")
public class PrioridadRest {

    @Autowired
    private PrioridadService prioridadService;

    @GetMapping("/todo")
    public List<Object[]> todoPrioridades() {
        return prioridadService.todoPrioridades();
    }
}
