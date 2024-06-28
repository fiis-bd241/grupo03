package com.example.bcp.service;

import com.example.bcp.model.Migracion;
import com.example.bcp.model.PreCarga;
import com.example.bcp.model.ReglaDeCargaFuncional;
import com.example.bcp.repository.ReglaDeCargaFuncionalRespository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class ReglaDeCargaFuncionalService {
    @Autowired
    private ReglaDeCargaFuncionalRespository reglaDeCargaFuncionalRespository;
    public List<Object[]> buscarReglaFuncPorMigracion(int migracionId) {
        return reglaDeCargaFuncionalRespository.buscarReglaFuncPorMigracion(migracionId);
    }
    @Transactional
    public void crearRegladeCargaFuncional(ReglaDeCargaFuncional reglaDeCargaFuncional){
        int migracionId = reglaDeCargaFuncional.getMigracionId().getMigracionId();
        int tecnologiaId= reglaDeCargaFuncional.getTecnologiaId().getTecnologiaId();
        String logica= reglaDeCargaFuncional.getLogica();
        Date fecha = reglaDeCargaFuncional.getFecha();
        reglaDeCargaFuncionalRespository.crearRegladeCargaFuncional(migracionId,tecnologiaId,logica);}
}
