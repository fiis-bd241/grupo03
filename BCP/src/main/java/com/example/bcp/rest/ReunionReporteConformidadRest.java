package com.example.bcp.rest;


import com.example.bcp.service.ReunionReporteConformidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reunion-reporte-conformidad/")
public class ReunionReporteConformidadRest {

    @Autowired
    private ReunionReporteConformidadService reunionReporteConformidadService;

    @PostMapping("/asociar-entrada")
    public void asociarReunionAReporteEntrada(@RequestBody Integer reunionId) {
        reunionReporteConformidadService.asociarReunionAReporteEntrada(reunionId);
    }

    @PostMapping("/asociar-salida")
    public void asociarReunionAReporteSalida(@RequestBody Integer reunionId) {
        reunionReporteConformidadService.asociarReunionAReporteSalida(reunionId);
    }
}
