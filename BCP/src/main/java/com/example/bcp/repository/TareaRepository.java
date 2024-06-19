package com.example.bcp.repository;

import com.example.bcp.model.Tarea;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TareaRepository extends JpaRepository<Tarea, Long> {

    @Query(value = "SELECT t.descripcion AS \"Seccion\", es.\"Estado_Tipo\" AS \"Estado\", e.nombre AS \"Responsable\" " +
            "FROM public.\"Tarea\" t " +
            "INNER JOIN public.\"Estado\" es ON t.estadoId = es.\"Estado_Id\" " +
            "INNER JOIN public.\"Migracion\" m ON t.id_migracion = m.\"Migracion_Id\" " +
            "INNER JOIN public.\"Empleado\" e ON t.id_empleado = e.id_empleado " +
            "WHERE t.id_migracion = ?1 " +
            "AND (t.descripcion = 'Agregar Concepto de Negocio' OR t.descripcion = 'Agregar Equivalencia' OR t.descripcion = 'Insertar Modelo DDV') ",
            nativeQuery = true)
    List<Object[]> findTodoTareasbyMigracionId(int migracionId);

    @Query(value = "SELECT" +
            " t.descripcion AS \"Tarea\"," +
            " t.fecha_fin AS \"Fecha Asignada\"," +
            " t.fecha_inicio AS \"Fecha Inicio\"," +
            " t.fecha_fin_real AS \"Fecha Fin\"," +
            " AGE(t.fecha_fin_real, t.fecha_inicio) AS \"Tiempo Demorado\" " +
            " FROM public.\"Tarea\" t" +
            " WHERE t.id_migracion = ?1 " +
            " AND (t.\"descripcion\" = 'Agregar Concepto de Negocio' " +
            " \t OR t.\"descripcion\" = 'Agregar Equivalencia' " +
            " \t OR t.\"descripcion\" = 'Insertar Modelo DDV') ",
    nativeQuery = true)
    List<Object[]> findReporteTareasbyMigracionId(int migracionId);

    @Query(value = "SELECT t.descripcion AS \"Tarea\"," +
            " CASE \n" +
            " WHEN t.fecha_fin_real IS NULL AND CURRENT_DATE > t.fecha_fin THEN 'retrasada' " +
            " WHEN t.fecha_fin_real IS NOT NULL AND t.fecha_fin_real <= t.fecha_fin THEN 'a tiempo' " +
            " ELSE 'retrasada' " +
            " END AS evaluacion " +
            "FROM public.\"Tarea\" t " +
            "WHERE t.id_migracion = ?1 " +
            "AND (t.descripcion = 'Agregar Concepto de Negocio' " +
            " OR t.descripcion = 'Agregar Equivalencia' " +
            " OR t.descripcion = 'Insertar Modelo DDV') ",
    nativeQuery = true)
    List<Object[]> getEvaluacionTareasbyMigracionId(int migracionId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE public.\"Tarea\"" +
            "SET estadoId = (" +
            "SELECT \"Estado_Id\"" +
            "FROM public.\"Estado\"" +
            "WHERE \"Estado_Tipo\" = :estado)" +
            "WHERE id_tarea = :tarea",
    nativeQuery = true)
    void actualizarEstadoTarea(@Param("estado") String estado, @Param("tarea") String tarea);
}