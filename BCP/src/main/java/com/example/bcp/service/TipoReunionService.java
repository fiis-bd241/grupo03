package com.example.bcp.service;

import com.example.bcp.model.TipoReunion;
import com.example.bcp.repository.TipoReunionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoReunionService  {

    @Autowired
    private TipoReunionRepository tipoReunionRepository;

    public List<Object[]> todosTiposReunionNombres() {
        return tipoReunionRepository.todosTiposReunionNombres();
    }

}