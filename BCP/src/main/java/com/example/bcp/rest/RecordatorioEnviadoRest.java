package com.example.bcp.rest;

import com.example.bcp.model.Recordatorio;
import com.example.bcp.service.RecordatorioEnviadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recordatorio-enviado/")
public class RecordatorioEnviadoRest {

    @Autowired
    private RecordatorioEnviadoService recordatorioEnviadoService;

    @PostMapping("/asociar-recordatorio")
    public void asociarRecordatorioAParticipantes(@RequestBody Recordatorio recordatorio) {
        recordatorioEnviadoService.asociarRecordatorioAParticipantes(recordatorio);
    }
}
