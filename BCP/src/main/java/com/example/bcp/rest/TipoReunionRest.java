package com.example.bcp.rest;

import com.example.bcp.service.TipoReunionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipoReunion/")
public class TipoReunionRest {

    @Autowired
    private TipoReunionService tipoReunionService;

    @GetMapping("/nombres")
    public List<Object[]> todosTiposReunionNombres() {
        return tipoReunionService.todosTiposReunionNombres();
    }

}
