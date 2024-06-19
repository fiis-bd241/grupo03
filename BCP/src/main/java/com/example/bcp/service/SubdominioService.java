package com.example.bcp.service;

import com.example.bcp.repository.SubdominioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubdominioService {

    @Autowired
    private SubdominioRepository subdominioRepository;

    public List<Object[]> getSubdominiosByDominioId(int dominioId) {
        return subdominioRepository.findSubdominiosByDominioId(dominioId);
    }
}
