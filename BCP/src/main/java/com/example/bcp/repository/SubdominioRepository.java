package com.example.bcp.repository;

import com.example.bcp.model.Subdominio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubdominioRepository extends JpaRepository<Subdominio, Long> {
    @Query(value = "SELECT id_subdominio, nombre_subdominio FROM public.\"Subdominio\" WHERE \"id_dominio\" = ?1", nativeQuery = true)
    List<Object[]> findSubdominiosByDominioId(int dominioId);
}
