package com.example.bcp.rest;

import com.example.bcp.model.Reunion;
import com.example.bcp.service.ParticipaEnService;
import com.example.bcp.service.ReunionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reunion/")
public class ReunionRest {

    @Autowired
    private ReunionService reunionService;
    @Autowired
    private ParticipaEnService participaEnService;

    @GetMapping("/completadas")
    public List<Object[]> obtenerReunionesCompletadas() {
        return reunionService.obtenerReunionesCompletadas();
    }

    @GetMapping("/pendientes")
    public List<Object[]> obtenerReunionesPendientes() {
        return reunionService.obtenerReunionesPendientes();
    }

    @GetMapping("/buscar")
    public List<Object[]> buscarReunionesPorTexto(@RequestParam String texto) {
        return reunionService.buscarReunionesPorTexto(texto);
    }

    @GetMapping("/estado")
    public List<Object[]> obtenerReunionesPorEstadoOrdenadas(@Param("estadoReunion") String estadoReunion, @Param("orden") String orden) {
        return reunionService.obtenerReunionesPorEstadoOrdenadas(estadoReunion, orden);
    }

    @PostMapping("/crear-reunion")
    public void crearReunion(@RequestBody Reunion reunion) {
        reunionService.crearReunion(reunion);
    }

    @PostMapping("/asociar-participantes")
    public void asociarParticipantesAReunion(@RequestParam Integer reunionId, @RequestParam List<Integer> participanteIds) {
        reunionService.asociarParticipantesAReunion(reunionId, participanteIds);
    }

    @GetMapping("/detalles-pendiente/{reunionId}")
    public List<Object[]> obtenerDetallesReunionPendiente(@PathVariable Integer reunionId) {
        return reunionService.obtenerDetallesReunionPendiente(reunionId);
    }

    @PutMapping("/marcar-completada/{reunionId}")
    public ResponseEntity<?> marcarReunionComoCompletada(@PathVariable Integer reunionId) {
        reunionService.marcarReunionComoCompletada(reunionId);
        return ResponseEntity.ok("Reunión marcada como completada");
    }

    @PutMapping("/{reunionId}")
    public ResponseEntity<?> editarReunion(@PathVariable Integer reunionId, @RequestBody Reunion reunion) {
        reunionService.editarReunion(reunionId, reunion.getFecha(), reunion.getHoraInicio(), reunion.getHoraFin(), reunion.getPlataforma(), reunion.getAgenda());
        return ResponseEntity.ok("Reunión actualizada correctamente");
    }

    @PostMapping("/{reunionId}/participante/{participanteId}")
    public void agregarParticipanteAReunion(@PathVariable Integer reunionId, @PathVariable Integer participanteId) {
        participaEnService.agregarParticipante(reunionId, participanteId);
    }

    @DeleteMapping("/{reunionId}/participante/{participanteId}")
    public ResponseEntity<?> eliminarParticipanteDeReunion(@PathVariable Integer reunionId, @PathVariable Integer participanteId) {
        participaEnService.eliminarParticipante(reunionId, participanteId);
        return ResponseEntity.ok("Participante eliminado de la reunión");
    }

}