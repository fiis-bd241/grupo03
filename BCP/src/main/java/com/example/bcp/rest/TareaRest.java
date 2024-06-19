package com.example.bcp.rest;

import com.example.bcp.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarea/")
public class TareaRest {

    @Autowired
    private TareaService tareaService;

    @GetMapping("/todo/{migracionId}")
    public List<Object[]> getTodoTareas(@PathVariable int migracionId){
        return tareaService.getTodoTareasbyMigracionId(migracionId);
    }

    @GetMapping("/reporte/{migracionId}")
    public List<Object[]> getReporteTareas(@PathVariable int migracionId){
        return tareaService.getReporteTareasbyMigracionId(migracionId);
    }

    @GetMapping("/evaluacion/{migracionId}")
    public List<Object[]> getEvaluacionTareas(@PathVariable int migracionId){
        return tareaService.getEvaluacionTareasbyMigracionId(migracionId);
    }

    @PutMapping("/actualizar-estado-tarea")
    public void actualizarEstadoTarea(
            @RequestParam("estado") String estado,
            @RequestParam("tarea") String tarea) {
        tareaService.actualizarEstadoTareas(estado, tarea);
    }
}
