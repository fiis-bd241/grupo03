package com.example.bcp.rest;

import com.example.bcp.model.Pedido;
import com.example.bcp.model.ReglaDeCargaFuncional;
import com.example.bcp.service.AmbienteService;
import com.example.bcp.service.CampoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Campo/")
public class CampoRest {
    @Autowired
    private CampoService campoService;
    @PutMapping("/crearCampo")
    public void crearCampo(
            @RequestParam("nivelDeAcceso") String nivelDeAcceso,
            @RequestParam("encriptacion") boolean encriptacion,
            @RequestParam("campoDDV") String campoDDV,
            @RequestParam("enmascarado") boolean enmascarado) {
        campoService.crearCampo(nivelDeAcceso,encriptacion,enmascarado,campoDDV);}
    @GetMapping("/camposPorPedido")
    public List<Object[]> camposPorPedido(@RequestBody Pedido pedido) {
        return campoService.camposPorPedido(pedido);
    }
}
