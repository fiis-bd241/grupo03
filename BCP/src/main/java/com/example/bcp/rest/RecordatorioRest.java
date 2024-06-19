package com.example.bcp.rest;


import com.example.bcp.service.RecordatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recordatorio/")
public class RecordatorioRest {

    @Autowired
    private RecordatorioService recordatorioService;

    @PostMapping("/crear-programacion-reunion")
    public ResponseEntity<Void> crearRecordatorioProgramacionReunion() {
        recordatorioService.crearRecordatorioProgramacionReunion();
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
