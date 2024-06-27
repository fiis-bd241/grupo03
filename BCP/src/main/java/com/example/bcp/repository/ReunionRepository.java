package com.example.bcp.repository;

import com.example.bcp.model.Reunion;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
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

    @Query(value = "SELECT r.\"Reunion_Id\", " +
            "tr.\"Nombre\" AS \"Tipo\", " +
            "r.\"Fecha\", " +
            "r.\"HoraInicio\" AS \"Inicio\", " +
            "r.\"HoraFin\" AS \"Fin\", " +
            "r.\"Pedido_Id\" " +
            "FROM public.\"Reunion\" r " +
            "INNER JOIN public.\"Tipo_Reunion\" tr ON r.\"TipoReunion_Id\" = tr.\"TipoReunion_Id\" " +
            "WHERE r.\"Pedido_Id\" = :pedidoId AND \"Estado\" = 'pendiente' " +
            "ORDER BY r.\"Fecha\" DESC, r.\"HoraInicio\" DESC",
            nativeQuery = true)
    List<Object[]> buscarReunionesPendientesporPedidoId(Integer pedidoId);
    @Query(value = "SELECT r.\"Reunion_Id\", " +
            "tr.\"Nombre\" AS \"Tipo\", " +
            "r.\"Fecha\", " +
            "r.\"HoraInicio\" AS \"Inicio\", " +
            "r.\"HoraFin\" AS \"Fin\", " +
            "r.\"Pedido_Id\" " +
            "FROM public.\"Reunion\" r " +
            "INNER JOIN public.\"Tipo_Reunion\" tr ON r.\"TipoReunion_Id\" = tr.\"TipoReunion_Id\" " +
            "WHERE r.\"Pedido_Id\" = :pedidoId AND \"Estado\" = 'completada' " +
            "ORDER BY r.\"Fecha\" DESC, r.\"HoraInicio\" DESC",
            nativeQuery = true)
    List<Object[]> buscarReunionesCompletadasporPedidoId(Integer pedidoId);

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
    @Query(value = "INSERT INTO public.\"Reunion\" (\"Id_Empleado\", \"Pedido_Id\", \"TipoReunion_Id\", \"HoraInicio\", \"HoraFin\", \"Plataforma\", \"Fecha\", \"Estado\", \"Agenda\",\"Acuerdos\", \"FechaProgramacion\", \"HoraProgramacion\") " +
            "VALUES (:idEmpleado, :pedidoId, :tipoReunionId, :horaInicio, :horaFin, :plataforma, :fecha, 'pendiente', :agenda,'...', CURRENT_DATE, CURRENT_TIME)",
            nativeQuery = true)
    void crearReunion(@Param("idEmpleado") int idEmpleado,
                      @Param("pedidoId") int pedidoId,
                      @Param("tipoReunionId") int tipoReunionId,
                      @Param("horaInicio") LocalTime horaInicio,
                      @Param("horaFin") LocalTime horaFin,
                      @Param("plataforma") String plataforma,
                      @Param("fecha") LocalDate fecha,
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
    void editarReunion(@Param("reunionId") Integer reunionId, @Param("fecha") LocalDate fecha, @Param("horaInicio") LocalTime horaInicio, @Param("horaFin") LocalTime horaFin, @Param("plataforma") String plataforma, @Param("agenda") String agenda);


    @Query(value = "SELECT MAX(\"Reunion_Id\") " +
            "FROM public.\"Reunion\"", nativeQuery = true)
    Integer MaxReunionId();

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM public.\"Reunion\"" +
            " WHERE \"Reunion_Id\" = :reunionId AND \"Estado\" = 'pendiente'", nativeQuery = true)
    void cancelarReunion(@Param("reunionId") Integer reunionId);


    @Modifying
    @Transactional
    @Query("UPDATE Reunion r " +
            "SET r.acuerdos = :acuerdos " +
            "WHERE r.reunionId = :id AND r.estado = 'completada'")
    void actualizarAcuerdos(@Param("id") Integer id,
                            @Param("acuerdos") String acuerdos);


}


