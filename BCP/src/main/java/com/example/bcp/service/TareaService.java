package com.example.bcp.service;

import com.example.bcp.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    public List<Object[]> getTodoTareasbyMigracionId(int migracionId) {
        return tareaRepository.findTodoTareasbyMigracionId(migracionId);
    }

    public List<Object[]> getReporteTareasbyMigracionId (int migracionId) {
        return tareaRepository.findReporteTareasbyMigracionId(migracionId);
    }

    public List<Object[]> getEvaluacionTareasbyMigracionId (int migracionId){
        return tareaRepository.getEvaluacionTareasbyMigracionId(migracionId);
    }

    public void actualizarEstadoTareas(String estado, String tarea){
        tareaRepository.actualizarEstadoTarea(estado, tarea);
    }
}
