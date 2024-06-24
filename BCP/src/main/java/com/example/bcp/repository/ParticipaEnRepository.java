package com.example.bcp.repository;

import com.example.bcp.model.ParticipaEn;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipaEnRepository extends JpaRepository<ParticipaEn, Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO public.\"Participa_en\" (\"Reunion_Id\", \"Participante_Id\") VALUES (:reunionId, :participanteId)",
            nativeQuery = true)
    void asociarParticipanteAReunion(@Param("reunionId") Integer reunionId, @Param("participanteId") Integer participanteId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO public.\"Participa_en\"(\"Reunion_Id\", \"Participante_Id\") VALUES (:reunionId, :participanteId)", nativeQuery = true)
    void agregarParticipante(@Param("reunionId") Integer reunionId, @Param("participanteId") Integer participanteId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM public.\"Participa_en\" WHERE \"Reunion_Id\" = :reunionId AND \"Participante_Id\" = :participanteId", nativeQuery = true)
    void eliminarParticipante(@Param("reunionId") Integer reunionId, @Param("participanteId") Integer participanteId);

    @Query(value = "SELECT pe.\"Id_Participa_en\", p.\"Nombre\" || ' ' || p.\"Apellido\" AS nombreCompleto " +
            "FROM \"Participa_en\" pe " +
            "INNER JOIN \"Participante\" p ON pe.\"Participante_Id\" = p.\"Participante_Id\" " +
            "WHERE pe.\"Reunion_Id\" = :reunionId", nativeQuery = true)
    List<Object[]> obtenerParticipantesPorReunionId(@Param("reunionId") Integer reunionId);

}
