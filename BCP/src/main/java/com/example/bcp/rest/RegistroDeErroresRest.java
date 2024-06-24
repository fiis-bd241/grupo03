package com.example.bcp.rest;

import com.example.bcp.model.Pedido;
import com.example.bcp.model.Programacion;
import com.example.bcp.model.RegistroDeErrores;
import com.example.bcp.service.AmbienteService;
import com.example.bcp.service.RegistroDeErroresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/RegistroDeErrores/")
public class RegistroDeErroresRest {
    @Autowired
    private RegistroDeErroresService registroDeErroresService;
    @GetMapping("/causasycorrecciones")
    public List<Object[]> todoCausasYCorreciones(@RequestBody Pedido pedido) {
        return registroDeErroresService.todoCausasYCorreciones(pedido);
    }
    @PutMapping("/registrar")
    public void registrarError(@RequestBody RegistroDeErrores registroDeErrores){
        registroDeErroresService.registrarError(registroDeErrores);}
}
