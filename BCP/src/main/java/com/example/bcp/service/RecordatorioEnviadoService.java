package com.example.bcp.service;

import com.example.bcp.model.Recordatorio;
import com.example.bcp.repository.RecordatorioEnviadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class RecordatorioEnviadoService {

    @Autowired
    private RecordatorioEnviadoRepository recordatorioEnviadoRepository;

    @Transactional
    public void asociarRecordatorioAParticipantes(Recordatorio recordatorio) {
        int reunionId = recordatorio.getReunionId().getReunionId();
        recordatorioEnviadoRepository.asociarRecordatorioAParticipantes(reunionId);
    }
}
