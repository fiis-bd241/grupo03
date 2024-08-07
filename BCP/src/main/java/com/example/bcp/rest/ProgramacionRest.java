package com.example.bcp.rest;

import com.example.bcp.model.Programacion;
import com.example.bcp.model.ReglaDeCargaFuncional;
import com.example.bcp.service.AmbienteService;
import com.example.bcp.service.ProgramacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Programacion/")
public class ProgramacionRest {
    @Autowired
    private ProgramacionService programacionService;
    @PostMapping("/asignar")
    public void asignarProgramacionAMigracion(@RequestBody Programacion programacion){

        programacionService.asignarProgramacionAMigracion(programacion);}
}
