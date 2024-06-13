package com.example.bcp.service;

import com.example.bcp.model.Tecnologia;
import com.example.bcp.repository.TecnologiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class TecnologiaService {

    @Autowired
    private TecnologiaRepository tecnologiaRepository;

    public List<Object[]> todoTecnologias() {
        return tecnologiaRepository.todoTecnologias();
    }
}
