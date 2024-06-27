package com.example.bcp.service;

import com.example.bcp.model.Migracion;
import com.example.bcp.model.ReglaDeCargaFuncional;
import com.example.bcp.model.ReglaDeCargaTecnica;
import com.example.bcp.repository.ReglaDeCargaTecnicaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReglaDeCargaTecnicaService {
    @Autowired
    private ReglaDeCargaTecnicaRepository reglaDeCargaTecnicaRepository;
    @Transactional
    public void enviarReglaParaRevision(Integer migracionId, String codigo){

        reglaDeCargaTecnicaRepository.enviarReglaParaRevision(migracionId,codigo);}
    @Transactional
    public void actualizarReglaParaRevision(Integer migracionId, String codigo){

        reglaDeCargaTecnicaRepository.actualizarReglaParaRevision(migracionId,codigo);}
    @Transactional
    public void finalizarReglaDeCarga(Integer migracionId, String comentario){
        reglaDeCargaTecnicaRepository.finalizarReglaDeCarga(migracionId,comentario);}

    @Transactional
    public void corregirReglaeDeCarga(Integer migracionId, String comentario){
        reglaDeCargaTecnicaRepository.corregirReglaeDeCarga(migracionId,comentario);}

}
