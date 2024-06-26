package com.example.bcp.rest;

import com.example.bcp.service.ReporteConformidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/vista-reporte-generado/{reporteId}")
    public List<Object[]> vistaReporteConformidadGenerado(@PathVariable Integer reporteId) {
        return reporteConformidadService.vistaReporteConformidadGenerado(reporteId);
    }


    @GetMapping("/existe")
    public ResponseEntity<Boolean> existeReporteConformidad(@RequestParam Integer reunionId) {
        boolean existe = reporteConformidadService.existeReporteConformidad(reunionId);
        return ResponseEntity.ok(existe);
    }

    @PostMapping("/crear")
    public ResponseEntity<Void> crearReporteConformidad(@RequestParam Integer reunionId) {
        reporteConformidadService.crearReporteConformidad(reunionId);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/ultimos-pedidos")
    public List<Integer> cuatroPedidosId() {
        return reporteConformidadService.cuatroPedidosId();
    }
    @GetMapping("/por-pedido/{pedidoId}")
    public List<Object[]> reportesConformidadPorPedidoId(@PathVariable Integer pedidoId) {
        return reporteConformidadService.reportesConformidadPorPedidoId(pedidoId);
    }

}
