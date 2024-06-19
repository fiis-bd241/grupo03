package com.example.bcp.service;

import com.example.bcp.repository.AmbienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmbienteService {

    @Autowired
    private AmbienteRepository ambienteRepository;

    public List<Object[]> todoAmbientes() {
        return ambienteRepository.todoAmbientes();
    }
}
