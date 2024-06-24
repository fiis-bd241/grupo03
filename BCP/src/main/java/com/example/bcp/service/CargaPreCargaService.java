package com.example.bcp.service;

import com.example.bcp.repository.CargaPreCargaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CargaPreCargaService {
    @Autowired
    private CargaPreCargaRepository cargaPreCargaRepository;

}
