package com.example.bcp.service;

import com.example.bcp.model.Migracion;
import com.example.bcp.model.Pedido;
import com.example.bcp.model.ReglaDeCargaTecnica;
import com.example.bcp.model.Universo;
import com.example.bcp.repository.UniversoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversoService {
    @Autowired
    private UniversoRepository universoRepository;
    public List<Object[]> buscarUniversoPorPedido(Pedido pedido) {
        Integer pedidoId= pedido.getPedidoId();
        return universoRepository.buscarUniversoPorPedido(pedidoId);
    }
    @Transactional
    public void crearUniverso(Universo universo){
        int pedidoId = universo.getPedidoId().getPedidoId();
        String codigo= universo.getCodigo();
        universoRepository.crearUniverso(pedidoId,codigo);}
}
