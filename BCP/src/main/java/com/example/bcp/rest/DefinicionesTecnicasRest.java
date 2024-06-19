package com.example.bcp.rest;

import com.example.bcp.model.DefinicionesTecnicas;
import com.example.bcp.service.DefinicionesTecnicasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/definicionestecnicas/")
public class DefinicionesTecnicasRest {

    @Autowired
    private DefinicionesTecnicasService definicionesTecnicasService;

    @GetMapping("/camposReferencia")
    public List<Object[]> getCamposfromDT() {return definicionesTecnicasService.getCampoReffromDT();}

    @GetMapping("/tablasReferencia")
    public List<String> getTablasReferencia() {
        return definicionesTecnicasService.getTablaReferencia();
    }

    @GetMapping("/esquemasOR/{tabla}")
    public List<Object[]> getEsquemasOR(@PathVariable String tabla) {
        return definicionesTecnicasService.getEsquemaOR(tabla);}

    @GetMapping("/tablasOR/{tabla}")
    public List<Object[]> getTablasOR(@PathVariable String tabla){
        return definicionesTecnicasService.getTablaOR(tabla);
    }

    @GetMapping("/camposOR/{tabla}")
    public List<Object[]> getCamposOR(@PathVariable String tabla){
        return definicionesTecnicasService.getCampoOR(tabla);
    }

    @GetMapping("/camposEquivalentes")
    public List<String> getCamposEquivalentes(){
        return definicionesTecnicasService.getCampoEquivalente();
    }

    @PutMapping("/actualizar-tabla-equivalente")
    public void actualizarTablaEquivalente(
            @RequestParam("tabla") String tabla,
            @RequestParam("campo") String campo){
        definicionesTecnicasService.actualizarTablasEquivalentes(tabla, campo);
    }
}