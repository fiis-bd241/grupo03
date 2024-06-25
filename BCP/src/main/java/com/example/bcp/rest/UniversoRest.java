package com.example.bcp.rest;

import com.example.bcp.model.Migracion;
import com.example.bcp.model.Pedido;
import com.example.bcp.model.PreCarga;
import com.example.bcp.model.Universo;
import com.example.bcp.service.TareaService;
import com.example.bcp.service.UniversoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Universo/")
public class UniversoRest {
    @Autowired
    private UniversoService universoService;
    @GetMapping("/buscarPorPedido")
    public List<Object[]> buscarUniversoPorPedido(@RequestBody Pedido pedido) {
        return universoService.buscarUniversoPorPedido(pedido);
    }
    @PostMapping("/crearUniverso")
    public void reglaDeCargaObligatoria(@RequestBody Universo universo){
        universoService.crearUniverso(universo);}
}
