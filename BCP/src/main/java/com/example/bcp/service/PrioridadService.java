package com.example.bcp.service;

import com.example.bcp.repository.PrioridadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PrioridadService {

    @Autowired
    private PrioridadRepository prioridadRepository;

    public List<Object[]> todoPrioridades() {
        return prioridadRepository.todoPrioridades();
    }
}
