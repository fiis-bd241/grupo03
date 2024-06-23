package com.example.bcp.rest;

import com.example.bcp.service.ModeladoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modelado/")
public class ModeladoRest {

    @Autowired
    private ModeladoService modeladoService;

    @GetMapping("/Modelo/{campo}")
    public List<Object[]> getTodoModelado(@PathVariable String campo){
        return modeladoService.getTodosModelos(campo);}

    @PostMapping("/crear-modelo")
    public void insertarModelo(
            @RequestParam("campoDDV") String campoDDV,
            @RequestParam("campoLlave") boolean campoLlave,
            @RequestParam("campoDescarta") boolean campoDescarta,
            @RequestParam("campo") String campo){
        modeladoService.insertarModelo(campoDDV,campoLlave,campoDescarta,campo);
    }

    @PutMapping("/actualizar-esquema-tabla")
    public void actualizarEsquemaTabla(
            @RequestParam("esquemaDDV") String esquemaDDV,
            @RequestParam("tablaDDV") String tablaDDV,
            @RequestParam("campo") String campo) {
        modeladoService.actualizarEsquemaTablas(esquemaDDV,tablaDDV,campo);
    }

}