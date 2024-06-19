package com.example.bcp.repository;
import com.example.bcp.model.ReunionReporteConformidad;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReunionReporteConformidadRepository  {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO public.\"Reunion_Reporte_Conformidad\" (\"Reunion_Id\", \"Reporte_Id\") " +
            "VALUES (:reunionId, (SELECT MIN(\"Reporte_Id\") FROM public.\"Reporte_Conformidad\" WHERE \"Pedido_Id\" = " +
            "(SELECT \"Pedido_Id\" FROM public.\"Reunion\" WHERE \"Reunion_Id\" = :reunionId)))",
            nativeQuery = true)
    void asociarReunionAReporteEntrada(@Param("reunionId") Integer reunionId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO public.\"Reunion_Reporte_Conformidad\" (\"Reunion_Id\", \"Reporte_Id\") " +
            "VALUES (:reunionId, (SELECT MAX(\"Reporte_Id\") FROM public.\"Reporte_Conformidad\" WHERE \"Pedido_Id\" = " +
            "(SELECT \"Pedido_Id\" FROM public.\"Reunion\" WHERE \"Reunion_Id\" = :reunionId)))",
            nativeQuery = true)
    void asociarReunionAReporteSalida(@Param("reunionId") Integer reunionId);
}

