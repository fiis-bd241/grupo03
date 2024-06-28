package com.example.bcp.repository;

import com.example.bcp.model.Prioridad;
import com.example.bcp.model.TipoError;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoErrorRepository extends JpaRepository<TipoError, Long> {

    @Query(value = "SELECT * FROM \"TipoError\"", nativeQuery = true)
    List<Object[]> todoErrores();
}
