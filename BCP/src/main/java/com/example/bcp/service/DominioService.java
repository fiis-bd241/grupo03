package com.example.bcp.service;

import com.example.bcp.repository.DominioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class DominioService {

    @Autowired
    private DominioRepository dominioRepository;

    public List<Object[]> todoDominios() {
        return dominioRepository.todoDominios();
    }

}
