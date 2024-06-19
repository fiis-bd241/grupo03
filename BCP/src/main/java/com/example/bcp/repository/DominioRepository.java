package com.example.bcp.repository;

import com.example.bcp.model.Dominio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DominioRepository extends JpaRepository<Dominio, Long> {

    @Query(value = "SELECT id_dominio, tipo_dominio FROM public.\"Dominio\"",
            nativeQuery = true)
    List<Object[]> todoDominios();
}
