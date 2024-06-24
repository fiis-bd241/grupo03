package com.example.bcp.rest;

import com.example.bcp.model.Reunion;
import com.example.bcp.service.ParticipaEnService;
import com.example.bcp.service.ReunionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/participaEn")
public class ParticipaEnRest {

    @Autowired
    private ParticipaEnService participaEnService;

    @GetMapping("/{reunionId}")
    public List<Object[]> obtenerParticipantesPorReunionId(@PathVariable Integer reunionId) {
        return participaEnService.obtenerParticipantesPorReunionId(reunionId);
    }
}

