package com.example.bcp.service;

import com.example.bcp.repository.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service

public class ParticipanteService {

    @Autowired
    private ParticipanteRepository participanteRepository;

    public List<Integer> todosParticipantesPorPedidoId(Integer pedidoId) {
        return participanteRepository.todosParticipantesPorPedidoId(pedidoId);
    }
    public String nombreCompletoPorParticipanteId(Integer participanteId) {
        return participanteRepository.nombreCompletoPorParticipanteId(participanteId);
    }

}