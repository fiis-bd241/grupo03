package com.example.bcp.rest;

import com.example.bcp.model.Pedido;
import com.example.bcp.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pedido/")
public class PedidoRest {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    private ResponseEntity<List<Pedido>> getAllPedidos() {
        return ResponseEntity.ok(pedidoService.findAll());
    }

    @PostMapping
    private ResponseEntity<Pedido> savePedido(@RequestBody Pedido pedido) {
        try {
            Pedido pedidoGuardado = pedidoService.save(pedido);
            return ResponseEntity.created(new URI("/pedido/" + pedidoGuardado.getPedidoId()))
                    .body(pedidoGuardado);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/top3")
    public List<Object[]> getTop3Pedidos() {
        return pedidoService.getTop3Pedidos();
    }

    @GetMapping("/todo")
    public List<Object[]> todosPedidos() {
        return pedidoService.todosPedidos();
    }
}
