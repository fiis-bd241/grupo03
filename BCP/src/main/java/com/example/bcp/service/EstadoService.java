package com.example.bcp.service;

import com.example.bcp.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Object[]> todoEstados() {
        return estadoRepository.todoEstados();
    }
}
