package com.example.bcp.rest;

import com.example.bcp.service.AmbienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ambiente/")
public class AmbienteRest {

    @Autowired
    private AmbienteService ambienteService;

    @GetMapping("/todo")
    public List<Object[]> todoAmbiente() {
        return ambienteService.todoAmbientes();
    }
}
