package com.example.bcp.rest;

import com.example.bcp.service.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/participante/")
public class ParticipanteRest {

    @Autowired
    private ParticipanteService participanteService;

    @GetMapping("/por-pedido/{pedidoId}")
    public List<Integer> todosParticipantesPorPedidoId(@PathVariable Integer pedidoId) {
        return participanteService.todosParticipantesPorPedidoId(pedidoId);
    }
    @GetMapping("/nombre/{participanteId}")
    public String nombreCompletoPorParticipanteId(@PathVariable Integer participanteId) {
        return participanteService.nombreCompletoPorParticipanteId(participanteId);
    }

}
