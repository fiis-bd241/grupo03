package com.example.bcp.rest;

import com.example.bcp.service.CargaPreCargaService;
import com.example.bcp.service.UniversoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/CPC/")
public class CargaPreCargaRest {
    @Autowired
    private CargaPreCargaService cargaPreCargaService;

}
