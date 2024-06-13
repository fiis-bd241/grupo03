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

    @GetMapping("/top3")
    public List<Object[]> getTop3Pedidos() {
        return pedidoService.getTop3Pedidos();
    }

    @GetMapping("/todo")
    public List<Object[]> todosPedidos() {
        return pedidoService.todosPedidos();
    }
}
