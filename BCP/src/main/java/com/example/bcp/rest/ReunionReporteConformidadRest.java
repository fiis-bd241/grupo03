package com.example.bcp.rest;


import com.example.bcp.service.ReunionReporteConformidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reunion-reporte-conformidad/")
public class ReunionReporteConformidadRest {

    @Autowired
    private ReunionReporteConformidadService reunionReporteConformidadService;

    @PostMapping("/asociar-entrada")
    public ResponseEntity<Void> asociarReunionEntrada(@RequestParam Integer reunionId) {
        reunionReporteConformidadService.asociarReunionAReporteEntrada(reunionId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/asociar-salida")
    public ResponseEntity<Void> asociarReunionSalida(@RequestParam Integer reunionId) {
        reunionReporteConformidadService.asociarReunionAReporteSalida(reunionId);
        return ResponseEntity.ok().build();
    }
}
