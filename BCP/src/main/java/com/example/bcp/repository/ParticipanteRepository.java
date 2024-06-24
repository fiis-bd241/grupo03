package com.example.bcp.repository;

import com.example.bcp.model.Participante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Long> {

    @Query(value = "SELECT \"Participante_Id\" " +
            "FROM public.\"Participante\" " +
            "WHERE \"Area_Id\" = (SELECT p.\"Area_Id\" " +
            "FROM public.\"Pedido\" p " +
            "WHERE p.\"Pedido_Id\" = :pedidoId)",
            nativeQuery = true)
    List<Integer> todosParticipantesPorPedidoId(@Param("pedidoId") Integer pedidoId);

    @Query(value = "SELECT \"Nombre\" || ' ' || \"Apellido\" AS nombreCompleto " +
            "FROM public.\"Participante\" " +
            "WHERE \"Participante_Id\" = :participanteId",
            nativeQuery = true)
    String nombreCompletoPorParticipanteId(@Param("participanteId") Integer participanteId);
}


