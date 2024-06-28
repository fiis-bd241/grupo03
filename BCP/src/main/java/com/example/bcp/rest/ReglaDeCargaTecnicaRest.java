package com.example.bcp.rest;

import com.example.bcp.service.ReglaDeCargaTecnicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/RCT/")
public class ReglaDeCargaTecnicaRest {
    @Autowired
    private ReglaDeCargaTecnicaService reglaDeCargaTecnicaService;

    @PostMapping("/enviarRCT")
    public void enviarReglaParaRevision(
            @RequestParam("migracionId") Integer migracionId,
            @RequestParam("codigo") String codigo) {
        reglaDeCargaTecnicaService.enviarReglaParaRevision(migracionId, codigo);
    }
    @PutMapping("/actualizarRCT")
    public void actualizarReglaParaRevision(
            @RequestParam("migracionId") Integer migracionId,
            @RequestParam("codigo") String codigo) {
        reglaDeCargaTecnicaService.actualizarReglaParaRevision(migracionId, codigo);
    }

    @PutMapping("/finalizarRCT")
    public void finalizarReglaDeCarga(
            @RequestParam("migracionId") Integer migracionId,
            @RequestParam("comentario") String comentario) {
        reglaDeCargaTecnicaService.finalizarReglaDeCarga(migracionId, comentario);
    }

    @PutMapping("/corregirRCT")
    public void corregirReglaeDeCarga(
            @RequestParam("migracionId") Integer migracionId,
            @RequestParam("comentario") String comentario) {
        reglaDeCargaTecnicaService.corregirReglaDeCarga(migracionId, comentario);
    }
    @GetMapping("/buscarRCT/{pedidoId}")
    public List<Object[]> reglaTecnicaPorMigracion(@PathVariable int pedidoId) {
        return reglaDeCargaTecnicaService.reglaTecnicaPorMigracion(pedidoId);
    }
}
