package com.example.bcp.service;

import com.example.bcp.model.Migracion;
import com.example.bcp.model.Pedido;
import com.example.bcp.repository.MigracionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MigracionService {

    @Autowired
    private MigracionRepository migracionRepository;

    public List<Object[]> getTop3Migraciones() {
        return migracionRepository.getTop3Migraciones();
    }

    public void crearMigracion(Migracion migracion) {

        int pedidoId = migracion.getPedidoId().getPedidoId();
        int ambienteId = migracion.getAmbienteId().getAmbienteId();
        int tecnologiaId = migracion.getTecnologiaId().getTecnologiaId();

        migracionRepository.crearMigracion(pedidoId, ambienteId, tecnologiaId);
    }

    public List<Object[]> buscarMigracionesPorPedidoId(int pedidoId) {
        return migracionRepository.buscarMigracionesPorPedidoId(pedidoId);
    }
}
