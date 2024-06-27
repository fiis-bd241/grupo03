package com.example.bcp.service;


import com.example.bcp.repository.ReporteConformidadRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class ReporteConformidadService  {

    @Autowired
    private ReporteConformidadRepository reporteConformidadRepository;

    public void actualizarEstadoReporteConformidad(Integer reunionId) {
        reporteConformidadRepository.actualizarEstadoReporteConformidad(reunionId);
    }

    public List<Object[]> generarVistaPreviaReporte(Integer reunionId) {
        return reporteConformidadRepository.generarVistaPreviaReporte(reunionId);
    }
    public List<Object[]> vistaReporteConformidadGenerado(Integer reporteId) {
        return reporteConformidadRepository.vistaReporteConformidadGenerado(reporteId);
    }

    public boolean existeReporteConformidad(Integer reunionId) {
        return reporteConformidadRepository.existeReporteConformidad(reunionId);
    }
    @Transactional
    public void crearReporteConformidad(Integer reunionId) {
        reporteConformidadRepository.crearReporteConformidad(reunionId);
    }
    public List<Integer> cuatroPedidosId() {
        return reporteConformidadRepository.cuatroPedidosId();
    }
    public List<Object[]> reportesConformidadPorPedidoId(Integer pedidoId) {
        return reporteConformidadRepository.reportesConformidadPorPedidoId(pedidoId);
    }

}
