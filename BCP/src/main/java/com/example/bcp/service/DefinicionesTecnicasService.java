package com.example.bcp.service;

import com.example.bcp.repository.DefinicionesTecnicasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefinicionesTecnicasService {

    @Autowired
    private DefinicionesTecnicasRepository definicionesTecnicasRepository;

    public List<Object[]> getCampoReffromDT() {return definicionesTecnicasRepository.getCamposReferenciafromDT() ;}

    public List<String> getTablaReferencia() {return definicionesTecnicasRepository.findTablasReferencia();}

    public List<Object[]> getEsquemaOR(String tabla) {
        return definicionesTecnicasRepository.findEsquemasOR(tabla);}

    public List<Object[]> getTablaOR(String tabla) {
        return definicionesTecnicasRepository.findTablasOR(tabla);}

    public List<Object[]> getCampoOR(String tabla) {
        return definicionesTecnicasRepository.findCamposOR(tabla);
    }

    public List<String> getCampoEquivalente() {
        return definicionesTecnicasRepository.findCamposEquivalentes();
    }


    public void actualizarTablasEquivalentes(String tabla, String campo){
        definicionesTecnicasRepository.actualizarTablaEquivalente(tabla,campo);
    }
}

