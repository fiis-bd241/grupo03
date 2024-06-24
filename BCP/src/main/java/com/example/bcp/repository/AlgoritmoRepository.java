package com.example.bcp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlgoritmoRepository {
    @Query(value = "SELECT \"nombre_algoritmo\" FROM \"Algoritmo\" al\n" +
            "WHERE al.tipo='Algoritmo de enmascaramiento'",
            nativeQuery = true)
    List<Object[]> todoAlgoritmoEnm();
    @Query(value = "SELECT \"nombre_algoritmo\" FROM \"Algoritmo\" al\n" +
            "WHERE al.tipo='Algoritmo de encriptación'",
            nativeQuery = true)
    List<Object[]> todoAlgoritmoEnc();
}
