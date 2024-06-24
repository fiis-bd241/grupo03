package com.example.bcp.service;

import com.example.bcp.model.CargaPreCarga;
import com.example.bcp.model.Migracion;
import com.example.bcp.model.Pedido;
import com.example.bcp.model.PreCarga;
import com.example.bcp.repository.PreCargaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PreCargaService {
    @Autowired
    private PreCargaRepository preCargaRepository;
    public List<Object[]> reglasObligatorias() {
        return preCargaRepository.reglasObligatorias();
    }
    public List<Object[]> reglasOpcionales() {
        return preCargaRepository.reglasOpcionales();
    }

    @Transactional
    public void relacionarCargaPrecarga(Integer migracionId, String nombreRegla){
        preCargaRepository.relacionarCargaPrecarga(migracionId,nombreRegla);
    }
    @Transactional
    public void reglaDeCargaObligatoria(PreCarga preCarga){
        String nombreRegla= preCarga.getNombreRegla();
        preCargaRepository.reglaDeCargaObligatoria(nombreRegla);
    }
}
