package com.example.bcp.rest;

import com.example.bcp.model.PreCarga;
import com.example.bcp.service.PreCargaService;
import com.example.bcp.service.UniversoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/PreCarga/")
public class PreCargaRest {
    @Autowired
    private PreCargaService preCargaService;
    @GetMapping("/Obligatorias")
    public List<Object[]> reglasObligatorias() {
        return preCargaService.reglasObligatorias();
    }
    @GetMapping("/Opcionales")
    public List<Object[]> reglasOpcionales() {
        return preCargaService.reglasOpcionales();
    }
    @PostMapping("/relacionarCPC")
    public void relacionarCargaPrecarga(
            @RequestParam("migracionId") Integer migracionId,
            @RequestParam("nombreRegla") String nombreRegla) {
                preCargaService.relacionarCargaPrecarga(migracionId,nombreRegla);}
    @PostMapping("/cargaObligatoria")
    public void reglaDeCargaObligatoria(@RequestBody PreCarga preCarga){
        preCargaService.reglaDeCargaObligatoria(preCarga);}
}



