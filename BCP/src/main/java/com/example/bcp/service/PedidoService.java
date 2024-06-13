package com.example.bcp.service;

import com.example.bcp.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Object[]> todosPedidos() {
        return pedidoRepository.todosPedidos();
    }

    public List<Object[]> getTop3Pedidos() {
        return pedidoRepository.getTop3Pedidos();
    }

    public List<Object[]> todosPedidosId() {
        return pedidoRepository.todosPedidosId();
    }
}
