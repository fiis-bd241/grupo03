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



    @GetMapping("/estado")
    public List<Object[]> obtenerReunionesPorEstadoOrdenadas(@Param("estadoReunion") String estadoReunion, @Param("orden") String orden) {
        return reunionService.obtenerReunionesPorEstadoOrdenadas(estadoReunion, orden);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearReunion(@RequestBody Reunion reunion) {
        reunionService.crearReunion(reunion);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

        @PostMapping("/{reunionId}/participantes")
    public ResponseEntity<Void> asociarParticipantes(@PathVariable Integer reunionId, @RequestBody List<Integer> participantesIds) {
        reunionService.asociarParticipantesAReunion(reunionId, participantesIds);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/detalles-pendiente/{reunionId}")
    public List<Object[]> obtenerDetallesReunionPendiente(@PathVariable Integer reunionId) {
        return reunionService.obtenerDetallesReunionPendiente(reunionId);
    }
    @GetMapping("/detalles-completada/{reunionId}")
    public List<Object[]> obtenerDetallesReunionCompletada(@PathVariable Integer reunionId) {
        return reunionService.obtenerDetallesReunionCompletada(reunionId);
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
    @GetMapping("/maxid")
    public Integer MaxReunionId() {
        return reunionService.MaxReunionId();
    }
    @DeleteMapping("/cancelar/{reunionId}")
    public ResponseEntity<?> cancelarReunion(@PathVariable Integer reunionId) {
        reunionService.cancelarReunion(reunionId);
        return ResponseEntity.ok("Reunión cancelada");
    }
    @PutMapping("/{id}/acuerdos")
    public void actualizarAcuerdos(@PathVariable Integer id, @RequestBody String acuerdos) {
        reunionService.actualizarAcuerdos(id, acuerdos);
    }
    @GetMapping("/pendiente-pedido/{pedidoId}")
    public List<Object[]> buscarReunionesPendientesporPedidoId(@PathVariable Integer pedidoId) {
        return reunionService.buscarReunionesPendientesporPedidoId(pedidoId);
    }
    @GetMapping("/completada-pedido/{pedidoId}")
    public List<Object[]> buscarReunionesCompletadasporPedidoId(@PathVariable Integer pedidoId) {
        return reunionService.buscarReunionesCompletadasporPedidoId(pedidoId);
    }
}