package com.example.bcp.service;

import com.example.bcp.repository.ModeladoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeladoService {

    @Autowired
    private ModeladoRepository modeladoRepository;

    public List<Object[]> getTodosModelos(String campo) {
        return modeladoRepository.findTodosModelos(campo);
    }

    public void insertarModelo(String campo, String campoDDV, boolean campoLlave, boolean campoDescarta){
        modeladoRepository.insertarModelo(campo, campoDDV, campoLlave,campoDescarta);
    }

    public void actualizarEsquemaTablas(String esquemaDDV, String tablaDDV, String campo){
        modeladoRepository.actualizarEsquemaTabla(esquemaDDV, tablaDDV, campo);
    }
}
