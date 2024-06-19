package com.example.bcp.service;

import com.example.bcp.model.Recordatorio;
import com.example.bcp.repository.RecordatorioRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RecordatorioService  {

    @Autowired
    private RecordatorioRepository recordatorioRepository;

    @Transactional
    public void crearRecordatorioProgramacionReunion() {
        recordatorioRepository.crearRecordatorioProgramacionReunion();
    }

}
