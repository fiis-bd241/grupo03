package com.example.bcp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.bcp.model.Algoritmo;

import java.util.List;

@Repository
public interface AlgoritmoRepository extends JpaRepository<Algoritmo, Integer> {
    @Query(value = "SELECT \"nombre_algoritmo\" FROM \"Algoritmo\" al WHERE al.tipo='Algoritmo de enmascaramiento'", nativeQuery = true)
    List<Object[]> todoAlgoritmoEnm();

    @Query(value = "SELECT \"nombre_algoritmo\" FROM \"Algoritmo\" al WHERE al.tipo='Algoritmo de encriptación'", nativeQuery = true)
    List<Object[]> todoAlgoritmoEnc();
}
