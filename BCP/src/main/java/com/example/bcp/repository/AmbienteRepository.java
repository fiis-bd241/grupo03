package com.example.bcp.repository;

import com.example.bcp.model.Ambiente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AmbienteRepository extends JpaRepository<Ambiente, Long> {

    @Query(value = "SELECT id_ambiente, nombre_ambiente FROM public.\"Ambiente\"",
            nativeQuery = true)
    List<Object[]> todoAmbientes();
}
