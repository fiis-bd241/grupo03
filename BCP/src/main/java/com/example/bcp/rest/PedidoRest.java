package com.example.bcp.rest;
import com.example.bcp.model.Pedido;
import com.example.bcp.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/todo-id")
    public List<Object[]> todosPedidosId() {
        return pedidoService.todosPedidosId();
    }

    @PostMapping("/crear-pedido")
    public void crearPedido(@RequestBody Pedido pedido) {
        pedidoService.crearPedido(pedido);
    }
}
