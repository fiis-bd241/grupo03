package com.example.bcp.service;

import com.example.bcp.model.Programacion;
import com.example.bcp.repository.EmpleadoRepository;
import com.example.bcp.repository.ProgramacionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgramacionService {
    @Autowired
    private ProgramacionRepository programacionRepository;
    @Transactional
    public void asignarProgramacionAMigracion(Programacion programacion){
        int migracionId=programacion.getMigracionId().getMigracionId();
        String frecuenciaEjecucion=programacion.getFrecuenciaEjecucion();
        String diaInicio=programacion.getDiaInicio();
        String diaFin=programacion.getDiaFin();
        String consideracionFrecuencia= programacion.getConsideracionFrecuencia();
        programacionRepository.asignarProgramacionAMigracion(migracionId,frecuenciaEjecucion,diaInicio,diaFin,consideracionFrecuencia);}
}
