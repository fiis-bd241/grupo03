package com.example.bcp.service;

import com.example.bcp.repository.ProgramacionRepository;
import com.example.bcp.repository.TipoDatoRepository;
import com.example.bcp.repository.TipoErrorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoErrorService {
    @Autowired
    private TipoErrorRepository tipoErrorRepository;
    public List<Object[]> todoNombresErrores() {
        return tipoErrorRepository.todoNombresErrores();}

}
