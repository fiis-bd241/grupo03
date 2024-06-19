package com.example.bcp.service;

import com.example.bcp.model.Empleado;
import com.example.bcp.repository.EmpleadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService  {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<String> todosProductOwner() {
        return empleadoRepository.todosProductOwner();
    }


}

