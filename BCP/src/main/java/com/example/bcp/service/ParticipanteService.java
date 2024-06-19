package com.example.bcp.service;

import com.example.bcp.model.Participante;
import com.example.bcp.repository.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service

public class ParticipanteService {

    @Autowired
    private ParticipanteRepository participanteRepository;

    public List<Integer> todosParticipantesPorPedidoId(Integer pedidoId) {
        return participanteRepository.todosParticipantesPorPedidoId(pedidoId);
    }
}