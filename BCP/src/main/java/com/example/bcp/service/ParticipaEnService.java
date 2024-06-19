package com.example.bcp.service;

import com.example.bcp.model.ParticipaEn;
import com.example.bcp.repository.ParticipaEnRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public class ParticipaEnService  {

    @Autowired
    private ParticipaEnRepository participaEnRepository;

    @Transactional
    public void asociarParticipanteAReunion(Integer reunionId,Integer participanteId) {
        participaEnRepository.asociarParticipanteAReunion(reunionId, participanteId);
    }
    @Transactional
    public void agregarParticipante(Integer reunionId, Integer participanteId) {
        participaEnRepository.agregarParticipante(reunionId, participanteId);
    }

    @Transactional
    public void eliminarParticipante(Integer reunionId, Integer participanteId) {
        participaEnRepository.eliminarParticipante(reunionId, participanteId);
    }

}
