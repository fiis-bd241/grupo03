package com.example.bcp.service;

import com.example.bcp.model.Campo;
import com.example.bcp.model.Pedido;
import com.example.bcp.model.ReglaDeCargaFuncional;
import com.example.bcp.repository.CampoRepository;
import com.example.bcp.repository.EmpleadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CampoService {
    @Autowired
    private CampoRepository campoRepository;
    @Transactional
    public void crearCampo(String nivelDeAcceso,boolean encriptacion,boolean enmascarado, String campoDDV){
        campoRepository.crearCampo(nivelDeAcceso,encriptacion,campoDDV,enmascarado);}

    public List<Object[]> camposPorPedido(Pedido pedido) {
        Integer pedidoId=pedido.getPedidoId();
        return campoRepository.camposPorPedido(pedidoId);
    }
}
