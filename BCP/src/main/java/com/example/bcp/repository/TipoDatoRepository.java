package com.example.bcp.repository;

import com.example.bcp.model.Prioridad;
import com.example.bcp.model.TipoDato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoDatoRepository extends JpaRepository<TipoDato, Long> {
    @Query(value = "SELECT \"Niveldeacceso\" FROM \"TipoDato\";", nativeQuery = true)
    List<Object[]> TodoNivelesDeAcceso();
    @Query(value = "SELECT \"Enmascarado\" FROM \"TipoDato\"\n" +
            "           GROUP BY \"Enmascarado\";", nativeQuery = true)
    List<Object[]> todoEnmascarado();
    @Query(value = "SELECT \"Encriptación\" FROM \"TipoDato\"\n" +
            "           GROUP BY \"Encriptación\";", nativeQuery = true)
    List<Object[]> todoEncriptado();
}
