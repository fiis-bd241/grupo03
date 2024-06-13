package com.example.bcp.service;

import com.example.bcp.model.Pedido;
import com.example.bcp.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

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
}
