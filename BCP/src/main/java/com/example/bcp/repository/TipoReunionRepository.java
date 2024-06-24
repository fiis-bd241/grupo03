package com.example.bcp.repository;

import com.example.bcp.model.TipoReunion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TipoReunionRepository  extends JpaRepository<TipoReunion, Integer> {

    @Query(value = "SELECT \"TipoReunion_Id\", \"Nombre\" FROM public.\"Tipo_Reunion\"" , nativeQuery = true)
    List<Object[]> todosTiposReunionNombres();

}
