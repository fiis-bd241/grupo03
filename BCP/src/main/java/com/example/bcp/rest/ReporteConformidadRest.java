package com.example.bcp.rest;

import com.example.bcp.service.ReporteConformidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reporte-conformidad")
public class ReporteConformidadRest {

    @Autowired
    private ReporteConformidadService reporteConformidadService;

    @PutMapping("/actualizar-estado/{reunionId}")
    public void actualizarEstadoReporteConformidad(@PathVariable Integer reunionId) {
        reporteConformidadService.actualizarEstadoReporteConformidad(reunionId);
    }

    @GetMapping("/vista-previa-reporte/{reunionId}")
    public List<Object[]> generarVistaPreviaReporte(@PathVariable Integer reunionId) {
        return reporteConformidadService.generarVistaPreviaReporte(reunionId);
    }
}
