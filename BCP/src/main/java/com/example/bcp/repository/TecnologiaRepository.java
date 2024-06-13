package com.example.bcp.repository;
import com.example.bcp.model.Tecnologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TecnologiaRepository extends JpaRepository<Tecnologia, Long>{

    @Query(value = "SELECT id_tecnologia, nombre_tecnologia FROM public.\"Tecnologia\"",
            nativeQuery = true)
    List<Object[]> todoTecnologias();
}
