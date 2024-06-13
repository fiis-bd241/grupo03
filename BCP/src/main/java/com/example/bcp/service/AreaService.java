package com.example.bcp.service;

import com.example.bcp.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AreaService {

    @Autowired
    private AreaRepository areaRepository;

    public List<Object[]> todoAreas() {
        return areaRepository.todoAreas();
    }
}
