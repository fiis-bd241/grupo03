package com.example.bcp.repository;

import com.example.bcp.model.ParticipaEn;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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

}
