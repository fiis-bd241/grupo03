package com.example.bcp.rest;

import com.example.bcp.service.SubdominioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subdominio/")
public class SubdominioRest {

    @Autowired
    private SubdominioService subdominioService;

    @GetMapping("/subdominiosxdominio/{dominioId}")
    public List<Object[]> getSubdominios(@PathVariable int dominioId){
        return subdominioService.getSubdominiosByDominioId(dominioId);
    }
}
