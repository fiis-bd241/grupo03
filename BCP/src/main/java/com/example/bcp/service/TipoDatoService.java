package com.example.bcp.service;

import com.example.bcp.repository.TipoDatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoDatoService {
    @Autowired
    private TipoDatoRepository tipoDatoRepository;

    public List<Object[]> todoEncriptado() {
        return tipoDatoRepository.todoEncriptado();}
    public List<Object[]> todoEnmascarado() {
        return tipoDatoRepository.todoEnmascarado();}
    public List<Object[]> TodoNivelesDeAcceso() {
        return tipoDatoRepository.TodoNivelesDeAcceso();}
}
