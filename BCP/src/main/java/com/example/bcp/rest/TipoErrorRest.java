package com.example.bcp.rest;

import com.example.bcp.service.AmbienteService;
import com.example.bcp.service.TipoErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/TipoError/")
public class TipoErrorRest {
    @Autowired
    private TipoErrorService tipoErrorService;
    @GetMapping("/todoErrores")
    public List<Object[]> todoErrores() {
        return tipoErrorService.todoErrores();
    }
}
