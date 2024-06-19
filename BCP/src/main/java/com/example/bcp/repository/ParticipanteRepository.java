package com.example.bcp.repository;

import com.example.bcp.model.Participante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Long> {

    @Query(value = "SELECT CONCAT(\"Nombre\", ' ', \"Apellido\") AS nombreCompleto " +
            "FROM public.\"Participante\" " +
            "WHERE \"Area_Id\" = (SELECT p.\"Area_Id\" " +
            "FROM public.\"Pedido\" p " +
            "WHERE p.\"Pedido_Id\" = :pedidoId)",
            nativeQuery = true)
    List<Integer> todosParticipantesPorPedidoId(@Param("pedidoId") Integer pedidoId);

}
