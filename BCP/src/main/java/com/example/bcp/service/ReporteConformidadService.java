package com.example.bcp.service;


import com.example.bcp.model.ReporteConformidad;
import com.example.bcp.repository.ReporteConformidadRepository;
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
public class ReporteConformidadService  {

    private ReporteConformidadRepository reporteConformidadRepository;

    public void actualizarEstadoReporteConformidad(Integer reunionId) {
        reporteConformidadRepository.actualizarEstadoReporteConformidad(reunionId);
    }

    public List<Object[]> generarVistaPreviaReporte(Integer reunionId) {
        return reporteConformidadRepository.generarVistaPreviaReporte(reunionId);
    }
}
