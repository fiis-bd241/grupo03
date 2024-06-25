//package com.example.bcp.rest;
//
//import com.example.bcp.service.ReglaDeCargaTecnicaService;
//import com.example.bcp.service.UniversoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/RCT/")
//public class ReglaDeCargaTecnicaRest {
//    @Autowired
//    private ReglaDeCargaTecnicaService reglaDeCargaTecnicaService;
//    @PutMapping("/enviarRCT")
//    public void enviarReglaParaRevision(
//            @RequestParam("migracionId") Integer migracionId,
//            @RequestParam("codigo") String codigo) {
//        reglaDeCargaTecnicaService.enviarReglaParaRevision(migracionId,codigo);}
//    @PutMapping("/finalizarRCT")
//    public void finalizarReglaDeCarga(
//            @RequestParam("migracionId") Integer migracionId,
//            @RequestParam("comentario") String comentario) {
//        reglaDeCargaTecnicaService.finalizarReglaDeCarga(migracionId,comentario);}
//    @PutMapping("/finalizarRCT")
//    public void corregirReglaeDeCarga(
//            @RequestParam("migracionId") Integer migracionId,
//            @RequestParam("comentario") String comentario) {
//        reglaDeCargaTecnicaService.corregirReglaeDeCarga(migracionId,comentario);}
//}
