package com.example.bcp.rest;

import com.example.bcp.model.Estado;
import com.example.bcp.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estado/")
public class EstadoRest {

    @Autowired
    private EstadoService estadoService;

    @GetMapping
    private ResponseEntity<List<Estado>> getAllEstados() {
        return ResponseEntity.ok(estadoService.findAll());
    }

    @GetMapping("/todo")
    public List<Object[]> todoEstados() {
        return estadoService.todoEstados();
    }
}
