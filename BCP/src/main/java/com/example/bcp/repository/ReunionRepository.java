package com.example.bcp.repository;

import com.example.bcp.model.Reunion;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReunionRepository extends JpaRepository<Reunion, Integer> {

    @Query(value = "SELECT r.\"Reunion_Id\" , " +
            "tr.\"Nombre\" as \"Tipo\", r.\"Fecha\", " +
            "r.\"HoraInicio\" as \"Inicio\", " +
            "r.\"HoraFin\" as \"Fin\", " +
            "r.\"Pedido_Id\" " +
            "FROM public.\"Reunion\" r " +
            "INNER JOIN public.\"Tipo_Reunion\" tr ON r.\"TipoReunion_Id\" = tr.\"TipoReunion_Id\" " +
            "WHERE \"Estado\" = 'completada' " +
            "ORDER BY \"Fecha\" DESC, \"HoraInicio\" DESC", nativeQuery = true)
    List<Object[]> obtenerReunionesCompletadas();

    @Query(value = "SELECT r.\"Reunion_Id\" , " +
            "tr.\"Nombre\" as \"Tipo\", r.\"Fecha\", " +
            "r.\"HoraInicio\" as \"Inicio\", " +
            "r.\"HoraFin\" as \"Fin\", " +
            "r.\"Pedido_Id\" " +
            "FROM public.\"Reunion\" r " +
            "INNER JOIN public.\"Tipo_Reunion\" tr ON r.\"TipoReunion_Id\" = tr.\"TipoReunion_Id\" " +
            "WHERE \"Estado\" = 'pendiente' " +
            "ORDER BY \"Fecha\" ASC, \"HoraInicio\" ASC", nativeQuery = true)
    List<Object[]> obtenerReunionesPendientes();

    @Query(value = "SELECT \"Reunion_Id\", " +
            "\"TipoReunion_Id\", " +
            "\"Fecha\", " +
            "\"HoraInicio\", " +
            "\"HoraFin\", " +
            "\"Pedido_Id\" " +
            "FROM public.\"Reunion\" " +
            "WHERE \"Reunion_Id\" LIKE %:textoBusqueda% OR " +
            "\"TipoReunion_Id\" LIKE %:textoBusqueda% OR " +
            "TO_CHAR(\"HoraInicio\"::time, 'HH24') LIKE %:textoBusqueda% OR " +
            "TO_CHAR(\"HoraFin\"::time,'HH24') LIKE %:textoBusqueda% OR " +
            "TO_CHAR(\"Fecha\", 'YYYY-MM-DD') LIKE %:textoBusqueda% OR " +
            "\"Pedido_Id\" LIKE %:textoBusqueda%", nativeQuery = true)
    List<Object[]> buscarReunionesPorTexto(String textoBusqueda);
    @Query(value = "SELECT 'R'|| r.\"Reunion_Id\" as \"Reunión\", " +
            "tr.\"Nombre\" as \"Tipo\", " +
            "r.\"Fecha\", " +
            "r.\"HoraInicio\" as \"Inicio\", " +
            "r.\"HoraFin\" as \"Fin\", " +
            "r.\"Pedido_Id\" " +
            "FROM public.\"Reunion\" r " +
            "INNER JOIN public.\"Tipo_Reunion\" tr ON r.\"TipoReunion_Id\" = tr.\"TipoReunion_Id\" " +
            "WHERE \"Estado\" = :estadoReunion " +
            "ORDER BY CASE WHEN :orden = 'ASC' THEN r.\"Fecha\" END ASC, " +
            "         CASE WHEN :orden = 'DESC' THEN r.\"Fecha\" END DESC", nativeQuery = true)
    List<Object[]> obtenerReunionesPorEstadoOrdenadas(@Param("estadoReunion") String estadoReunion, @Param("orden") String orden);

    @Query(value = "SELECT \"Acuerdos\" FROM \"Reunion\" R\n" +
            "WHERE R.\"Pedido_Id\"=:pedidoId", nativeQuery = true)
    List<Object[]> obtenerAcuerdosPorPedido(@Param("pedidoId") Integer pedidoId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO public.\"Reunion\" (\"Id_Empleado\", \"Pedido_Id\", \"TipoReunion_Id\", \"HoraInicio\", \"HoraFin\", \"Plataforma\", \"Fecha\", \"Estado\", \"Agenda\", \"FechaProgramacion\", \"HoraProgramacion\") " +
            "VALUES (:idEmpleado, :pedidoId, :tipoReunionId, :horaInicio, :horaFin, :plataforma, :fecha, 'pendiente', :agenda, CURRENT_DATE, CURRENT_TIME)",
            nativeQuery = true)
    void crearReunion(@Param("idEmpleado") int idEmpleado,
                      @Param("pedidoId") int pedidoId,
                      @Param("tipoReunionId") int tipoReunionId,
                      @Param("horaInicio") Date horaInicio,
                      @Param("horaFin") Date horaFin,
                      @Param("plataforma") String plataforma,
                      @Param("fecha") Date fecha,
                      @Param("agenda") String agenda);

    @Query(value = "SELECT 'R'|| r.\"Reunion_Id\" as \"Reunión\", " +
            "tr.\"Nombre\" as \"Tipo\", " +
            "r.\"Fecha\", " +
            "r.\"HoraInicio\" as \"Inicio\", " +
            "r.\"HoraFin\" as \"Fin\", " +
            "(\"HoraFin\"::time - \"HoraInicio\"::time) AS \"Duración\", " +
            "r.\"Plataforma\", " +
            "r.\"Agenda\" " +
            "FROM public.\"Reunion\" r " +
            "INNER JOIN public.\"Tipo_Reunion\" tr ON r.\"TipoReunion_Id\" = tr.\"TipoReunion_Id\" " +
            "WHERE \"Reunion_Id\" = :reunionId AND \"Estado\" = 'pendiente'", nativeQuery = true)
    List<Object[]> obtenerDetallesReunionPendiente(@Param("reunionId") Integer reunionId);

    @Query(value = "SELECT 'R'|| r.\"Reunion_Id\" as \"Reunión\", " +
            "tr.\"Nombre\" as \"Tipo\", " +
            "r.\"Fecha\", " +
            "r.\"HoraInicio\" as \"Inicio\", " +
            "r.\"HoraFin\" as \"Fin\", " +
            "(\"HoraFin\"::time - \"HoraInicio\"::time) AS \"Duración\", " +
            "r.\"Plataforma\", " +
            "r.\"Agenda\", " +
            "r.\"Acuerdos\" " +
            "FROM public.\"Reunion\" r " +
            "INNER JOIN public.\"Tipo_Reunion\" tr ON r.\"TipoReunion_Id\" = tr.\"TipoReunion_Id\" " +
            "WHERE r.\"Reunion_Id\" = :reunionId AND r.\"Estado\" = 'completada'", nativeQuery = true)
    List<Object[]> obtenerDetallesReunionCompletada(@Param("reunionId") Integer reunionId);


    @Modifying
    @Transactional
    @Query(value = "UPDATE public.\"Reunion\" SET \"Estado\" = 'completada' WHERE \"Reunion_Id\" = :reunionId", nativeQuery = true)
    void marcarReunionComoCompletada(@Param("reunionId") Integer reunionId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE public.\"Reunion\" SET \"Fecha\" = :fecha, \"HoraInicio\" = :horaInicio, \"HoraFin\" = :horaFin, \"Plataforma\" = :plataforma, \"Agenda\" = :agenda WHERE \"Reunion_Id\" = :reunionId", nativeQuery = true)
    void editarReunion(@Param("reunionId") Integer reunionId, @Param("fecha") Date fecha, @Param("horaInicio") Date horaInicio, @Param("horaFin") Date horaFin, @Param("plataforma") String plataforma, @Param("agenda") String agenda);


}

