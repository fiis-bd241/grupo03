package com.example.bcp.service;

import com.example.bcp.repository.EsquemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EsquemaService {

    @Autowired
    private EsquemaRepository esquemaRepository;

    public List<Object[]> getEsquemasByAmbienteId(int ambienteId) {
        return esquemaRepository.findEsquemasByAmbienteId(ambienteId);
    }
}
