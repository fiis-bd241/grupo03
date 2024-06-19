package com.example.bcp.rest;

import com.example.bcp.service.EsquemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/esquema/")
public class EsquemaRest {

    @Autowired
    private EsquemaService esquemaService;

    @GetMapping("/esquemasxambiente/{ambienteId}")
    public List<Object[]> getEsquemas(@PathVariable int ambienteId) {
        return esquemaService.getEsquemasByAmbienteId(ambienteId);
    }
}
