package com.example.bcp.service;

import com.example.bcp.model.Reunion;
import com.example.bcp.repository.ReunionReporteConformidadRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReunionReporteConformidadService {

    @Autowired
    private ReunionReporteConformidadRepository reunionReporteConformidadRepository;

    @Transactional
    public void asociarReunionAReporteEntrada(Integer reunionId) {
        reunionReporteConformidadRepository.asociarReunionAReporteEntrada(reunionId);
    }

    @Transactional
    public void asociarReunionAReporteSalida(Integer reunionId) {
        reunionReporteConformidadRepository.asociarReunionAReporteSalida(reunionId);
    }
}

