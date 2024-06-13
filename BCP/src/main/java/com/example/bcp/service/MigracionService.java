package com.example.bcp.service;

import com.example.bcp.repository.MigracionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MigracionService {

    @Autowired
    private MigracionRepository migracionRepository;

    public List<Object[]> getTop3Migraciones() {
        return migracionRepository.getTop3Migraciones();
    }
}
