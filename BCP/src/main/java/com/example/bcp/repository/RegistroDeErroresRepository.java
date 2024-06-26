package com.example.bcp.repository;

import com.example.bcp.model.Prioridad;
import com.example.bcp.model.RegistroDeErrores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RegistroDeErroresRepository extends JpaRepository<RegistroDeErrores, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO \"RegistroErrores\" (\n" +
            "\"Migracion_Id\",\"Id_error\",\"Id_Empleado\",\"Correcion_error\",\"Fecha_registro\",\"Causa_error\")\n" +
            "VALUES \n" +
            "(:migracionId, (SELECT \"Id_error\" FROM \"TipoError\"\n" +
            "   WHERE \"Nombre_error\" = :nombreError),SELECT id_empleado FROM \"Empleado\"\n" +
            "WHERE \"Empleado\".\"nombre\"=:nombre,:correcionError,CURRENT_DATE,:causaError);", nativeQuery = true)
    void registrarError(@Param("migracionId") int migracionId,
                                       @Param("nombre") String nombre,
                                       @Param("nombreError") String nombreError,
                                       @Param("correcionError") String correcionError,
                                       @Param("causaError") String causaError);
    @Query(value = "SELECT  \"Causa_error\", \"Correcion_error\" FROM \"RegistroErrores\" re\n" +
            "INNER JOIN \"Migracion\" mg ON mg.\"Migracion_Id\"=re.\"Migracion_Id\"\n" +
            "WHERE mg.\"Pedido_Id\"=:pedidoId", nativeQuery = true)
    List<Object[]> todoCausasYCorreciones(@Param("pedidoId") Integer pedidoId);
}
