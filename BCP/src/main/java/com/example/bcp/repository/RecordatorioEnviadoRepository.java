package com.example.bcp.repository;

import com.example.bcp.model.RecordatorioEnviado;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordatorioEnviadoRepository extends JpaRepository<RecordatorioEnviado, Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO public.\"Recordatorio_Enviado\" (\"Recordatorio_Id\", \"Participante_Id\") " +
            "(SELECT r.\"Recordatorio_Id\", p.\"Participante_Id\" " +
            "FROM public.\"Recordatorio\" r " +
            "JOIN public.\"Participa_en\" pe ON r.\"Reunion_Id\" = pe.\"Reunion_Id\" " +
            "JOIN public.\"Participante\" p ON pe.\"Participante_Id\" = p.\"Participante_Id\" " +
            "WHERE r.\"Reunion_Id\"= :reunionId AND r.\"TipoRecordatorio_Id\" = 5)",
            nativeQuery = true)
    void asociarRecordatorioAParticipantes(@Param("reunionId") Integer reunionId);
}
