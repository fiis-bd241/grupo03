package com.example.bcp.rest;

import com.example.bcp.service.ConceptosNegocioService;
import com.example.bcp.service.DefinicionesTecnicasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asociar-tablas")
public class asociarTablasRest {

    @Autowired
    private DefinicionesTecnicasService definicionesTecnicasService;

    @Autowired
    private ConceptosNegocioService conceptosNegocioService;

    @PutMapping("/asociar")
    public ResponseEntity<?> asociarCamposATabla(@RequestParam String tabla,
                                                 @RequestParam String definicion,
                                                 @RequestParam List<String> camposSeleccionados) {
        try {
            // Actualizar la tabla y definición en "DefinicionesTecnicas"
            definicionesTecnicasService.actualizarTabla(tabla, camposSeleccionados);

            // Actualizar la definición de tabla en "ConceptosNegocio"
            conceptosNegocioService.actualizarDefTabla(definicion, camposSeleccionados);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
        }
    }
}
