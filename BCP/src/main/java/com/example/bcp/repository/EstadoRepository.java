package com.example.bcp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bcp.model.Estado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EstadoRepository  extends JpaRepository<Estado, Long> {

    @Query(value = "SELECT \"Estado_Id\", \"Estado_Tipo\" FROM public.\"Estado\"",
            nativeQuery = true)
    List<Object[]> todoEstados();
}
