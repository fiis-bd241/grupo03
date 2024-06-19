package com.example.bcp.rest;

import com.example.bcp.service.DominioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dominio/")
public class DominioRest {

    @Autowired
    private DominioService dominioService;

    @GetMapping("/todo")
    public List<Object[]> todoDominio() {
        return dominioService.todoDominios();
    }
}
