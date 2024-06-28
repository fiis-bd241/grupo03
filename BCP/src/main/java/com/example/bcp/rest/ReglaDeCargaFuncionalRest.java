package com.example.bcp.rest;

import com.example.bcp.model.Migracion;
import com.example.bcp.model.PreCarga;
import com.example.bcp.model.ReglaDeCargaFuncional;
import com.example.bcp.service.ReglaDeCargaFuncionalService;
import com.example.bcp.service.UniversoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/RCF/")
public class ReglaDeCargaFuncionalRest {
    @Autowired
    private ReglaDeCargaFuncionalService reglaDeCargaFuncionalService;
    @GetMapping("/RCFPorMigracion/{migracionId}")
    public List<Object[]> buscarReglaFuncPorMigracion(@PathVariable int migracionId) {
        return reglaDeCargaFuncionalService.buscarReglaFuncPorMigracion(migracionId);
    }
    @PostMapping("/crearRCF")
    public void crearRegladeCargaFuncional(@RequestBody ReglaDeCargaFuncional reglaDeCargaFuncional){
        reglaDeCargaFuncionalService.crearRegladeCargaFuncional(reglaDeCargaFuncional);}

}
