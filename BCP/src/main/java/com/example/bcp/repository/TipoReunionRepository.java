package com.example.bcp.repository;

import com.example.bcp.model.TipoReunion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoReunionRepository  extends CrudRepository<TipoReunion, Integer> {

    @Query(value = "SELECT nombre FROM Tipo_Reunion", nativeQuery = true)
    List<String> todosTiposReunionNombres();
}
