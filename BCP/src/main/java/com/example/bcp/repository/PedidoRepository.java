package com.example.bcp.repository;
import com.example.bcp.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

    @Query(value = "SELECT " +
            "p.\"Pedido_Id\" AS \"Pedido\", " +
            "a.\"Area_Nombre\" AS \"Área Solicitante\", " +
            "s.nombre_squad AS \"Squad Encargado\", " +
            "e.\"Estado_Tipo\" AS \"Estado\", " +
            "pr.\"Prioridad_Tipo\" AS \"Prioridad\", " +
            "p.\"Pedido_Fecha\" AS \"Fecha del Pedido\", " +
            "p.\"Pedido_FechaLimite\" AS \"Fecha Límite\" " +
            "FROM public.\"Pedido\" p " +
            "INNER JOIN public.\"Area\" a ON a.\"Area_Id\" = p.\"Area_Id\" " +
            "INNER JOIN public.\"Estado\" e ON e.\"Estado_Id\" = p.\"Estado_Id\" " +
            "INNER JOIN public.\"Prioridad\" pr ON p.\"Prioridad_Id\" = p.\"Prioridad_Id\" " +
            "ORDER BY p.\"Pedido_FechaLimite\" DESC",
            nativeQuery = true)
    List<Object[]> todosPedidos();

    @Query(value = "SELECT " +
            "p.\"Pedido_Id\" AS \"Pedido\", " +
            "a.\"Area_Nombre\" AS \"Área Solicitante\", " +
            "s.nombre_squad AS \"Squad Encargado\", " +
            "e.\"Estado_Tipo\" AS \"Estado\", " +
            "pr.\"Prioridad_Tipo\" AS \"Prioridad\", " +
            "p.\"Pedido_Fecha\" AS \"Fecha del Pedido\", " +
            "p.\"Pedido_FechaLimite\" AS \"Fecha Límite\" " +
            "FROM public.\"Pedido\" p " +
            "INNER JOIN public.\"Area\" a ON a.\"Area_Id\" = p.\"Area_Id\" " +
            "INNER JOIN public.\"Estado\" e ON e.\"Estado_Id\" = p.\"Estado_Id\" " +
            "INNER JOIN public.\"Prioridad\" pr ON p.\"Prioridad_Id\" = p.\"Prioridad_Id\" " +
            "ORDER BY p.\"Pedido_FechaLimite\" DESC " +
            "LIMIT 3",
            nativeQuery = true)
    List<Object[]> getTop3Pedidos();

    @Query(value = "SELECT \"Pedido_Id\" FROM public.\"Pedido\"",
            nativeQuery = true)
    List<Object[]> todosPedidosId();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO public.\"Pedido\"(\"Area_Id\", \"Id_Squad\", \"Prioridad_Id\", \"Estado_Id\", \"Pedido_Fecha\", \"Pedido_FechaLimite\") " +
            "VALUES (:areaId, :squadId, :prioridadId, :estadoId, CURRENT_DATE, :pedidoFechaLimite)", nativeQuery = true)
    void crearPedido(@Param("areaId") int areaId,
                     @Param("squadId") int squadId,
                     @Param("prioridadId") int prioridadId,
                     @Param("estadoId") int estadoId,
                     @Param("pedidoFechaLimite") java.util.Date pedidoFechaLimite);
}
