package com.example.bcp.repository;

import com.example.bcp.model.Esquema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EsquemaRepository extends JpaRepository<Esquema, Long> {

    @Query(value = "SELECT id_esquema, nombre_esquema FROM public.\"Esquema\" WHERE \"AmbienteId\" = ?1", nativeQuery = true)
    List<Object[]> findEsquemasByAmbienteId(int ambienteId);
}