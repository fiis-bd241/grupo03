package com.example.bcp.service;

import com.example.bcp.model.Pedido;
import com.example.bcp.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
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

    public void crearPedido(Pedido pedido) {
        int areaId = pedido.getAreaId().getAreaId();
        int squadId = pedido.getSquadId().getSquadId();
        int prioridadId = pedido.getPrioridadId().getPrioridadId();
        Date pedidoFechaLimite = pedido.getPedidoFechaLimite();

        pedidoRepository.crearPedido(areaId, squadId, prioridadId, pedidoFechaLimite);
    }

    public List<Object[]> PedidosPorFechas(Date fechaInicio, Date fechaFin) {
        return pedidoRepository.PedidosPorFechas(fechaInicio, fechaFin);
    }

}