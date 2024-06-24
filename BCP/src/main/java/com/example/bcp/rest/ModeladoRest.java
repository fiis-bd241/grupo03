package com.example.bcp.rest;

import com.example.bcp.service.ModeladoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modelado/")
public class ModeladoRest {

    @Autowired
    private ModeladoService modeladoService;

    @GetMapping("/Modelo/{campo}")
    public List<Object[]> getTodoModelado(@PathVariable String campo) {
        return modeladoService.getTodosModelos(campo);
    }

    @PostMapping("/crear-modelo")
    public ResponseEntity<?> insertarModelo(
            @RequestParam("campo") String campo,
            @RequestParam("campoDDV") String campoDDV,
            @RequestParam("campoLlave") boolean campoLlave,
            @RequestParam("campoDescarta") boolean campoDescarta) {
        modeladoService.insertarModelo(campo, campoDDV, campoLlave, campoDescarta);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/actualizar-esquema-tabla/{campo}")
    public ResponseEntity<?>  actualizarEsquemaTabla(
            @PathVariable("campo") String campo,
            @RequestParam("esquemaDDV") String esquemaDDV,
            @RequestParam("tablaDDV") String tablaDDV) {
        modeladoService.actualizarEsquemaTablas(esquemaDDV, tablaDDV, campo);
        return ResponseEntity.ok().build();
    }
}
