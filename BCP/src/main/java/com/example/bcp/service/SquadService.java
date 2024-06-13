package com.example.bcp.service;

import com.example.bcp.repository.SquadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SquadService {

    @Autowired
    private SquadRepository squadRepository;

    public List<Object[]> todoSquads() {
        return squadRepository.todoSquads();
    }
}
