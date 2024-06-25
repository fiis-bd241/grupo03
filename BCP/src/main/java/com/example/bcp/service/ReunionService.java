package com.example.bcp.service;

import com.example.bcp.model.Reunion;
import com.example.bcp.repository.ParticipaEnRepository;
import com.example.bcp.repository.ReunionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Service
public class ReunionService  {

    @Autowired
    private ReunionRepository reunionRepository;

    @Autowired
    private ParticipaEnRepository participaEnRepository;

    public List<Object[]> obtenerReunionesCompletadas() {
        return reunionRepository.obtenerReunionesCompletadas();
    }

    public List<Object[]> obtenerReunionesPendientes() {
        return reunionRepository.obtenerReunionesPendientes();
    }

    public List<Object[]> buscarReunionesPorTexto(String textoBusqueda) {
        return reunionRepository.buscarReunionesPorTexto(textoBusqueda);
    }

    public List<Object[]> obtenerReunionesPorEstadoOrdenadas(String estadoReunion, String orden) {
        return reunionRepository.obtenerReunionesPorEstadoOrdenadas(estadoReunion, orden);
    }
    @Transactional
    public void crearReunion(Reunion reunion) {
        try {
            int idEmpleado = reunion.getIdEmpleado().getIdEmpleado();
            int pedidoId = reunion.getPedidoId().getPedidoId();
            int tipoReunionId = reunion.getTipoReunionId().getTipoReunionId();
            LocalTime horaInicio = reunion.getHoraInicio();
            LocalTime horaFin = reunion.getHoraFin();
            String plataforma = reunion.getPlataforma();
            LocalDate fecha = reunion.getFecha();
            String agenda = reunion.getAgenda();

            reunionRepository.crearReunion(idEmpleado, pedidoId, tipoReunionId, horaInicio, horaFin, plataforma, fecha, agenda);
        } catch (Exception e) {
            // Log the error and rethrow or handle it
            System.err.println("Error creating reunion: " + e.getMessage());
            throw e;
        }
    }


    @Transactional
    public void asociarParticipantesAReunion(Integer reunionId, List<Integer> participanteIds) {
        for (Integer participanteId : participanteIds) {
            participaEnRepository.asociarParticipanteAReunion(reunionId, participanteId);
        }
    }

    public List<Object[]> obtenerDetallesReunionPendiente(Integer reunionId) {
        return reunionRepository.obtenerDetallesReunionPendiente(reunionId);
    }
    public List<Object[]> obtenerDetallesReunionCompletada(Integer reunionId) {
        return reunionRepository.obtenerDetallesReunionCompletada(reunionId);
    }

    @Transactional
    public void marcarReunionComoCompletada(Integer reunionId) {
        reunionRepository.marcarReunionComoCompletada(reunionId);
    }
    @Transactional
    public void editarReunion(Integer reunionId, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin, String plataforma, String agenda) {
        reunionRepository.editarReunion(reunionId, fecha, horaInicio, horaFin, plataforma, agenda);
    }
    public Integer MaxReunionId() {
        return reunionRepository.MaxReunionId();
    }
    public void cancelarReunion(Integer reunionId) {
        reunionRepository.cancelarReunion(reunionId);
    }

}