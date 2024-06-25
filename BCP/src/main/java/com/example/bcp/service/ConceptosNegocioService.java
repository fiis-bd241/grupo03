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

    public void insertarDatos(
            Integer esquemaId1,
            String campo1,
            Integer esquemaId2,
            String campo2,
            Integer subdominioId,
            String definicionCampo
    ) {
        conceptosNegocioRepository.insertarDatos(esquemaId1, campo1, esquemaId2, campo2, subdominioId, definicionCampo);
    }

    public void actualizarDefTabla(String definicion, List<String> camposSeleccionados) {
        conceptosNegocioRepository.actualizarDefinicionTabla(definicion,camposSeleccionados);
    }
}
