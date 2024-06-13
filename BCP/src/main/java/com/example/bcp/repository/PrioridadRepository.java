package com.example.bcp.repository;
import com.example.bcp.model.Prioridad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PrioridadRepository extends JpaRepository<Prioridad, Integer>{

    @Query(value = "SELECT \"Prioridad_Id\", \"Prioridad_Tipo\" FROM public.\"Prioridad\"",
            nativeQuery = true)
    List<Object[]> todoPrioridades();
}
