package com.example.bcp.rest;

import com.example.bcp.model.Migracion;
import com.example.bcp.model.Pedido;
import com.example.bcp.service.MigracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/migracion/")
public class MigracionRest {

    @Autowired
    private MigracionService migracionService;

    @GetMapping("/top3")
    public List<Object[]> getTop3Migraciones() {
        return migracionService.getTop3Migraciones();
    }

    @PostMapping("/crear-migracion")
    public void crearMigracion(@RequestBody Migracion migracion) {
        migracionService.crearMigracion(migracion);
    }

    @GetMapping("/todo/{pedidoId}")
    public List<Object[]> buscarMigracionesPorPedidoId(@PathVariable int pedidoId) {
        return migracionService.buscarMigracionesPorPedidoId(pedidoId);
    }
    @GetMapping("/mIdpId")
    public List<Object[]> migracionIdporPedidoId(@RequestParam ("pedidoId") Integer pedidoId) {
        return migracionService.migracionIdporPedidoId(pedidoId);
    }
}
