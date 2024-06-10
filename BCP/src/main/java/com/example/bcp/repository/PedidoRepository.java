package com.example.bcp.repository;
import com.example.bcp.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

    @Query(value = "SELECT " +
            "p.\"Pedido_Id\" AS \"Pedido\", " +
            "a.\"Area_Nombre\" AS \"Área Solicitante\", " +
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


}
