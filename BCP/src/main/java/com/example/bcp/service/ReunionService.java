package com.example.bcp.service;

import com.example.bcp.model.Reunion;
import com.example.bcp.repository.ReunionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class ReunionService  {

    @Autowired
    private ReunionRepository reunionRepository;

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
        int idEmpleado = reunion.getIdEmpleado().getIdEmpleado();
        int pedidoId = reunion.getPedidoId().getPedidoId();
        int tipoReunionId = reunion.getTipoReunionId().getTipoReunionId();
        Date horaInicio = reunion.getHoraInicio();
        Date horaFin = reunion.getHoraFin();
        String plataforma = reunion.getPlataforma();
        Date fecha = reunion.getFecha();
        String agenda = reunion.getAgenda();

        reunionRepository.crearReunion(idEmpleado, pedidoId, tipoReunionId, horaInicio, horaFin, plataforma, fecha, agenda);
    }


    public List<Object[]> obtenerDetallesReunionPendiente(Integer reunionId) {
        return reunionRepository.obtenerDetallesReunionPendiente(reunionId);
    }

    @Transactional
    public void marcarReunionComoCompletada(Integer reunionId) {
        reunionRepository.marcarReunionComoCompletada(reunionId);
    }
    @Transactional
    public void editarReunion(Integer reunionId, Date fecha, Date horaInicio, Date horaFin, String plataforma, String agenda) {
        reunionRepository.editarReunion(reunionId, fecha, horaInicio, horaFin, plataforma, agenda);
    }
}