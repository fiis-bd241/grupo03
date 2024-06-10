package com.example.bcp.rest;

import com.example.bcp.model.Tecnologia;
import com.example.bcp.service.TecnologiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tecnologia/")
public class TecnologiaRest {

    @Autowired
    private TecnologiaService tecnologiaService;

    @GetMapping
    private ResponseEntity<List<Tecnologia>> getAllTecnologias() {
        return ResponseEntity.ok(tecnologiaService.findAll());
    }

    @GetMapping("/todo")
    public List<Object[]> todoSquad() {
        return tecnologiaService.todoTecnologias();
    }
}
