package com.example.bcp.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bcp.model.Migracion;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MigracionRepository extends JpaRepository<Migracion, Long> {

    @Query(value = "SELECT m.\"Migracion_Id\" AS \"Migración\", " +
            "m.\"Pedido_Id\" AS \"Pedido\", " +
            "t.\"nombre_tecnologia\" AS \"Tecnología Usada\", " +
            "a.\"nombre_ambiente\" AS \"Entorno\", " +
            "m.\"Fecha_migracion\" AS \"Fecha de Migración\" " +
            "FROM public.\"Migracion\" m " +
            "INNER JOIN public.\"Tecnologia\" t ON t.id_tecnologia = m.\"Id_Tecnologia\" " +
            "INNER JOIN public.\"Ambiente\" a ON a.id_ambiente = m.\"AmbienteId\" " +
            "ORDER BY m.\"Fecha_migracion\" DESC " +
            "LIMIT 3",
            nativeQuery = true)
    List<Object[]> getTop3Migraciones();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO public.\"Migracion\" (" +
            "\"Pedido_Id\", \"AmbienteId\", \"Id_Tecnologia\", \"Fecha_migracion\", \"Valido\") " +
            "VALUES (:pedidoId, :ambienteId, :tecnologiaId, CURRENT_DATE, true)",
            nativeQuery = true)
    void crearMigracion(@Param("pedidoId") int pedidoId,
                        @Param("ambienteId") int ambienteId,
                        @Param("tecnologiaId") int tecnologiaId);

    @Query(value = "SELECT m.\"Pedido_Id\" AS \"Pedido\", " +
            "m.\"Migracion_Id\" AS \"Migración\", " +
            "t.\"nombre_tecnologia\" AS \"Tecnología Usada\", " +
            "a.\"nombre_ambiente\" AS \"Entorno\", " +
            "m.\"Fecha_migracion\" AS \"Fecha de Migración\" " +
            "FROM public.\"Migracion\" m " +
            "INNER JOIN public.\"Tecnologia\" t ON t.id_tecnologia = m.\"Id_Tecnologia\" " +
            "INNER JOIN public.\"Ambiente\" a ON a.id_ambiente = m.\"AmbienteId\" " +
            "WHERE m.\"Pedido_Id\" = :pedidoId " +
            "ORDER BY m.\"Fecha_migracion\" DESC",
            nativeQuery = true)
    List<Object[]> buscarMigracionesPorPedidoId(@Param("pedidoId") int pedidoId);

    @Query(value = "SELECT \"Migracion_Id\" FROM \"Migracion\" mg\n" +
            "WHERE mg.\"Pedido_Id\"=:pedidoId",
            nativeQuery = true)
    List<Object[]> migracionIdporPedidoId(@Param("pedidoId") int pedidoId);
}