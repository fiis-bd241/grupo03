package com.example.bcp.repository;

import com.example.bcp.model.ReglaDeCargaTecnica;
import com.example.bcp.model.Universo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository

public interface UniversoRepository extends JpaRepository<Universo,Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO \"Universo\"(\"Pedido_Id\",\"Codigo\",\"Fecha_Creacion\")\n" +
            "VALUES(:pedidoId,:codigo,CURRENT_DATE)", nativeQuery = true)
    void crearUniverso(@Param("pedidoId") int pedidoId,
                                    @Param("codigo") String codigo);
    @Query(value = " SELECT \"Codigo\" FROM \"Universo\" U\n" +
            " WHERE  U.\"Pedido_Id\"=:pedidoId", nativeQuery = true)
    List<Object[]> buscarUniversoPorPedido(@Param("pedidoId") Integer pedidoId);
}
