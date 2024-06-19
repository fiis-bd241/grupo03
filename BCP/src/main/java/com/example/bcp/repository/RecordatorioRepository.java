package com.example.bcp.repository;

import com.example.bcp.model.Recordatorio;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordatorioRepository extends JpaRepository<Recordatorio, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO public.\"Recordatorio\" (\"Reunion_Id\", \"TipoRecordatorio_Id\", \"Hora\", \"Fecha\") " +
            "SELECT \"Reunion_Id\", 5, \"HoraProgramacion\", \"FechaProgramacion\" " +
            "FROM public.\"Reunion\" " +
            "WHERE \"Estado\" = 'pendiente' AND \"Reunion_Id\"= (SELECT MAX(\"Reunion_Id\") FROM public.\"Reunion\")",
            nativeQuery = true)
    void crearRecordatorioProgramacionReunion();
}
