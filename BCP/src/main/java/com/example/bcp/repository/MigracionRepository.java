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

    @Query(value = "SELECT " +
            "m.\"Migracion_Id\" AS \"Migración\", " +
            "m.\"Pedido_Id\" AS \"Pedido\", " +
            "s.nombre_squad AS \"Squad Encargado\", " +
            "t.nombre_tecnologia AS \"Tecnología Usada\", " +
            "m.\"Fecha_migracion\" AS \"Fecha\" " +
            "FROM public.\"Migracion\" m " +
            "INNER JOIN public.\"Squad\" s ON s.id_squad = m.\"Id_Squad\" " +
            "INNER JOIN public.\"Tecnologia\" t ON t.id_tecnologia = m.\"Id_Tecnologia\" " +
            "ORDER BY m.\"Fecha_migracion\" DESC " +
            "LIMIT 3",
            nativeQuery = true)
    List<Object[]> getTop3Migraciones();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO public.\"Migracion\"(\"Pedido_Id\", \"Id_Squad\", \"Id_Tecnologia\", \"Entorno\", \"Fecha_migracion\", \"Valido\", \"Ultimo\") " +
            "VALUES (:pedidoId, :squadId, :tecnologiaId, :entorno, CURRENT_DATE, true, true)", nativeQuery = true)
    void crearMigracion(@Param("pedidoId") int pedidoId, @Param("squadId") int squadId,
                         @Param("tecnologiaId") int tecnologiaId, @Param("entorno") String entorno);

    @Query(value = "SELECT m.\"Pedido_Id\" AS \"Pedido\", " +
            "m.\"Migracion_Id\" AS \"Migración\", "+
            "s.nombre_squad AS \"Squad Encargado\", " +
            "t.nombre_tecnologia AS \"Tecnología Usada\", " +
            "m.\"Fecha_migracion\" AS \"Fecha\" " +
            "FROM public.\"Migracion\" m " +
            "INNER JOIN public.\"Squad\" s ON s.id_squad = m.\"Id_Squad\" " +
            "INNER JOIN public.\"Tecnologia\" t ON t.id_tecnologia = m.\"Id_Tecnologia\" " +
            "WHERE m.\"Pedido_Id\" = :pedidoId " +
            "ORDER BY m.\"Fecha_migracion\"",
            nativeQuery = true)
    List<Object[]> buscarMigracionesPorPedidoId(@Param("pedidoId") int pedidoId);
}
