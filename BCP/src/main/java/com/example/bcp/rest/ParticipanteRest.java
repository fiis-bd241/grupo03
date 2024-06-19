package com.example.bcp.rest;

import com.example.bcp.service.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/participante/")
public class ParticipanteRest {

    @Autowired
    private ParticipanteService participanteService;

    @GetMapping("/por-pedido/{pedidoId}")
    public List<Integer> todosParticipantesPorPedidoId(@PathVariable Integer pedidoId) {
        return participanteService.todosParticipantesPorPedidoId(pedidoId);
    }
}
