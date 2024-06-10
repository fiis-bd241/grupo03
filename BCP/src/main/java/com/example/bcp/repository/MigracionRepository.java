package com.example.bcp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bcp.model.Migracion;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

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
}
