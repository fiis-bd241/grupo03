package com.example.bcp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bcp.model.Estado;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EstadoRepository  extends JpaRepository<Estado, Long> {

    @Query(value = "SELECT \"Estado_Id\", \"Estado_Tipo\" FROM public.\"Estado\"",
            nativeQuery = true)
    List<Object[]> todoEstados();
}
