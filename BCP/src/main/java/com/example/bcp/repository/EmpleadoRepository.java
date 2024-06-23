package com.example.bcp.repository;

import com.example.bcp.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository <Empleado,Integer>{
    @Query(value = "SELECT e.\"id_empleado\",e.\"nombre\" " +
            "FROM \"Empleado\" e " +
            "INNER JOIN \"Roles\" r ON e.\"rol_id\" = r.\"id_rol\" " +
            "WHERE r.\"nombre_rol\" = 'Product Owner'",
            nativeQuery = true)
    List<Object[]> todosProductOwner();


    @Query(value = "SELECT e.id_empleado AS ID, " +
        "e.dni AS \"N° de acceso (DNI)\", " +
        "e.nombre AS \"nombre\", " +
        "r.nombre_rol AS \"rol\", " +
        "e.contraseña AS \"contraseña\", " +
        "e.correo AS \"Correo\", " +
        "e.telefono AS \"Teléfono\" " +
        "FROM public.\"Empleado\" e " +
        "JOIN public.\"Roles\" r ON e.rol_id = r.id_rol",
        nativeQuery = true)
    List<Object[]> obtenerTodosLosEmpleados();
    
    @Query(value = "SELECT e FROM Empleado e WHERE e.dni = :dni AND e.contraseña = :contrasena")
    Empleado findByDniAndContrasena(@Param("dni") String dni, @Param("contrasena") String contrasena);

}
