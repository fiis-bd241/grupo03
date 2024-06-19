package com.example.bcp.repository;

import com.example.bcp.model.ConceptosNegocio;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConceptosNegocioRepository extends JpaRepository<ConceptosNegocio, Long> {

    @Query(value = "SELECT " +
            "d.\"tipo_dominio\" AS \"dominio\", " +
            " s.\"nombre_subdominio\" AS \"subdominio\"," +
            "e.\"nombre_esquema\" AS \"esquema\", " +
            "dt.\"Tabla\" AS \"Tabla\", " +
            "dt.\"Campo\" AS \"Campo\"," +
            "cn.\"DefinicionTabla\"," +
            "cn.\"DefinicionCampo\" " +
            "FROM public.\"ConceptosNegocio\" cn " +
            "INNER JOIN public.\"Subdominio\" s ON cn.\"id_subdominio\" = s.\"id_subdominio\"" +
            "INNER JOIN public.\"Dominio\" d ON s.\"id_dominio\" = d.\"id_dominio\"" +
            "INNER JOIN public.\"DefinicionesTecnicas\" dt ON cn.\"id_referencia\" = dt.\"id_DT\"" +
            "INNER JOIN public.\"Esquema\" e ON dt.\"EsquemaId\" = e.\"id_esquema\"",
            nativeQuery = true)
    List<Object[]> todosConceptosNegocio();

    @Query(value = "SELECT " +
            "d.\"tipo_dominio\" AS \"dominio\", " +
            " s.\"nombre_subdominio\" AS \"subdominio\"," +
            "e.\"nombre_esquema\" AS \"esquema\", " +
            "dt.\"Tabla\" AS \"Tabla\", " +
            "dt.\"Campo\" AS \"Campo\"," +
            "cn.\"DefinicionTabla\"," +
            "cn.\"DefinicionCampo\" " +
            "FROM public.\"ConceptosNegocio\" cn " +
            "INNER JOIN public.\"Subdominio\" s ON cn.\"id_subdominio\" = s.\"id_subdominio\"" +
            "INNER JOIN public.\"Dominio\" d ON s.\"id_dominio\" = d.\"id_dominio\"" +
            "INNER JOIN public.\"DefinicionesTecnicas\" dt ON cn.\"id_referencia\" = dt.\"id_DT\"" +
            "INNER JOIN public.\"Esquema\" e ON dt.\"EsquemaId\" = e.\"id_esquema\"" +
            "LIMIT 7",
            nativeQuery = true)
    List<Object[]> get7ConceptosNegocio();

    @Modifying
    @Transactional
    @Query(value = "UPDATE \"ConceptosNegocio\" cn " +
            "SET cn.definicionTabla = :definicion " +
            "WHERE cn.idReferencia = ( " +
            "SELECT dt.idDT" +
            "FROM \"DefinicionesTecnicas\" dt" +
            "WHERE dt.equivalenciaId IS NULL" +
            "AND dt.campo = :campo ",
    nativeQuery = true)
    void actualizarDefinicionTabla(@Param("definicion") String definicion, @Param("campo") String campo);
}