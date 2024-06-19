package com.example.bcp.rest;

import com.example.bcp.service.ConceptosNegocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conceptosNegocio/")
public class ConceptosNegocioRest {

    @Autowired
    private ConceptosNegocioService conceptosNegocioService;

    @GetMapping("/todo")
    public List<Object[]> todosConceptosNegocio() {
        return conceptosNegocioService.todosConceptoNegocio();}

    @GetMapping("/top7")
    public List<Object[]> get7ConceptosNegocio() {
        return conceptosNegocioService.get7ConceptoNegocio();
    }

    @PostMapping("/actualizar-definicion-tabla")
    public void actualizarDefinicionTabla(
            @RequestParam("definicion") String definicion,
            @RequestParam("campo") String campo) {
        conceptosNegocioService.actualizarDefTabla(definicion, campo);
    }
}
