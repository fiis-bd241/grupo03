package com.example.bcp.rest;

import com.example.bcp.service.ConceptosNegocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/insercion-cn")
public class InsertarDataRest {

    @Autowired
    private ConceptosNegocioService conceptosNegocioService;

    @PostMapping("/guardar")
    public ResponseEntity<?> insertData(
            @RequestParam Integer esquemaId1,
            @RequestParam String campo1,
            @RequestParam Integer esquemaId2,
            @RequestParam String campo2,
            @RequestParam Integer subdominioId,
            @RequestParam String definicionCampo
    ) {
        try {
            conceptosNegocioService.insertarDatos(esquemaId1, campo1, esquemaId2, campo2, subdominioId, definicionCampo);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
        }
    }
}
