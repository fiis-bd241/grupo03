package com.example.bcp.repository;

import com.example.bcp.model.ReporteConformidad;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReporteConformidadRepository extends JpaRepository<ReporteConformidad, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO public.\"Reporte_Conformidad\" (\"Pedido_Id\", \"Tipo_Reporte\", \"Fecha\", \"Estado\") " +
            "VALUES ((SELECT \"Pedido_Id\" FROM public.\"Reunion\" WHERE \"Reunion_Id\" = :reunionId), " +
            "(SELECT tr.\"Nombre\" FROM public.\"Reunion\" r INNER JOIN public.\"Tipo_Reunion\" tr ON r.\"TipoReunion_Id\" = tr.\"TipoReunion_Id\" WHERE r.\"Reunion_Id\" = :reunionId), " +
            "CURRENT_DATE, 'pendiente')", nativeQuery = true)
    void crearReporteConformidad(@Param("reunionId") Integer reunionId);


    @Query(value = "UPDATE public.\"Reporte_Conformidad\" " +
            "SET \"Estado\" = 'completado', " +
            "\"Fecha\" = CURRENT_DATE " +
            "WHERE \"Reporte_Id\" = (SELECT \"Reporte_Id\" " +
            "FROM public.\"Reunion_Reporte_Conformidad\" " +
            "WHERE \"Reunion_Id\" = :reunionId)", nativeQuery = true)
    void actualizarEstadoReporteConformidad(@Param("reunionId") Integer reunionId);

    @Query(value = "SELECT r.\"Reunion_Id\", rc.\"Tipo_Reporte\", r.\"Fecha\", r.\"HoraInicio\", r.\"HoraFin\", r.\"Acuerdos\" ,rc.\"Pedido_Id\"" +
            "FROM public.\"Reunion_Reporte_Conformidad\" rrc " +
            "JOIN public.\"Reunion\" r ON rrc.\"Reunion_Id\" = r.\"Reunion_Id\" " +
            "JOIN public.\"Reporte_Conformidad\" rc ON rrc.\"Reporte_Id\" = rc.\"Reporte_Id\" " +
            "WHERE r.\"Pedido_Id\" = ( " +
            "    SELECT \"Pedido_Id\" " +
            "    FROM public.\"Reunion\" " +
            "    WHERE \"Reunion_Id\" = :reunionId " +
            ") " +
            "AND r.\"TipoReunion_Id\" = ( " +
            "    SELECT tr.\"TipoReunion_Id\" " +
            "    FROM public.\"Reunion\" r " +
            "    INNER JOIN public.\"Tipo_Reunion\" tr ON r.\"TipoReunion_Id\" = tr.\"TipoReunion_Id\" " +
            "    WHERE r.\"Reunion_Id\" = :reunionId " +
            ") " +
            "AND rc.\"Estado\" = 'completado'", nativeQuery = true)
    List<Object[]> generarVistaPreviaReporte(@Param("reunionId") Integer reunionId);

    @Query(value = "SELECT COUNT(*) > 0 " +
            "FROM public.\"Reporte_Conformidad\" rc " +
            "WHERE rc.\"Pedido_Id\" = (SELECT \"Pedido_Id\" " +
            "    FROM public.\"Reunion\" " +
            "    WHERE \"Reunion_Id\" = :reunionId) " +
            "AND rc.\"Tipo_Reporte\" = (SELECT tr.\"Nombre\" " +
            "    FROM public.\"Reunion\" r " +
            "    INNER JOIN public.\"Tipo_Reunion\" tr ON r.\"TipoReunion_Id\" = tr.\"TipoReunion_Id\" " +
            "    WHERE r.\"Reunion_Id\" = :reunionId)", nativeQuery = true)
    boolean existeReporteConformidad(@Param("reunionId") Integer reunionId);

}