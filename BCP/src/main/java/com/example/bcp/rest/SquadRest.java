package com.example.bcp.rest;

import com.example.bcp.service.SquadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/squad/")
public class SquadRest {

    @Autowired
    private SquadService squadService;

    @GetMapping("/todo")
    public List<Object[]> todoSquad() {
        return squadService.todoSquads();
    }
}
