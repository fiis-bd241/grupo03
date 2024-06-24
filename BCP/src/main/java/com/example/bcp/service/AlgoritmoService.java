package com.example.bcp.service;

import com.example.bcp.model.Migracion;
import com.example.bcp.repository.AlgoritmoRepository;
import com.example.bcp.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlgoritmoService {
    @Autowired
    private AlgoritmoRepository algoritmoRepository;

    public List<Object[]> todoAlgoritmoEnc() {
        return algoritmoRepository.todoAlgoritmoEnc();
    }
    public List<Object[]> todoAlgoritmoEnm() {
        return algoritmoRepository.todoAlgoritmoEnm();
    }
}
