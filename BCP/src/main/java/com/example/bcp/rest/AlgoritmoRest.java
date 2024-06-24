package com.example.bcp.rest;

import com.example.bcp.service.AlgoritmoService;
import com.example.bcp.service.AmbienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Algoritmo/")
public class AlgoritmoRest {
    @Autowired
    private AlgoritmoService algoritmoService;
    @GetMapping("/todoEnm")
    public List<Object[]> todoAlgoritmoEnm() {
        return algoritmoService.todoAlgoritmoEnm();
    }
    @GetMapping("/todoEnc")
    public List<Object[]> todoAlgoritmoEnc() {
        return algoritmoService.todoAlgoritmoEnc();
    }

}
