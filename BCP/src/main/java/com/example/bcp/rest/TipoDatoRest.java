package com.example.bcp.rest;

import com.example.bcp.model.Pedido;
import com.example.bcp.service.AmbienteService;
import com.example.bcp.service.TipoDatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/TipoDato/")
public class TipoDatoRest {
    @Autowired
    private TipoDatoService tipoDatoService;
    @GetMapping("/todoEncriptado")
    public List<Object[]> todoEncriptado() {
        return tipoDatoService.todoEncriptado();
    }
    @GetMapping("/todoEnmascarado")
    public List<Object[]> todoEnmascarado() {
        return tipoDatoService.todoEnmascarado();
    }
    @GetMapping("/todoNivelesDeAcceso")
    public List<Object[]> TodoNivelesDeAcceso() {
        return tipoDatoService.TodoNivelesDeAcceso();
    }
}
