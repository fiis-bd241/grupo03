package com.example.bcp.service;

import com.example.bcp.repository.ConceptosNegocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConceptosNegocioService {

    @Autowired
    private ConceptosNegocioRepository conceptosNegocioRepository;

    public List<Object[]> todosConceptoNegocio() {
        return conceptosNegocioRepository.todosConceptosNegocio();
    }

    public List<Object[]> get7ConceptoNegocio() {return conceptosNegocioRepository.get7ConceptosNegocio();}

    public void actualizarDefTabla(String definicion, String campo){
        conceptosNegocioRepository.actualizarDefinicionTabla(definicion, campo);
    }
}
