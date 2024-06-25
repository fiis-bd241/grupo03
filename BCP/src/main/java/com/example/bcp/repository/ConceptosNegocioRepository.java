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
    @Query(value = "UPDATE \"ConceptosNegocio\"  " +
            "SET \"DefinicionTabla\" = :definicion " +
            "WHERE \"id_referencia\" IN " +
            "(SELECT \"id_DT\"" +
            "FROM \"DefinicionesTecnicas\" " +
            "WHERE \"EquivalenciaId\" IS NULL " +
            "AND \"Campo\" IN :camposSeleccionados) ",
    nativeQuery = true)
    void actualizarDefinicionTabla(@Param("definicion") String definicion, @Param("camposSeleccionados") List<String> camposSeleccionados);

    @Query(value = "SELECT insertar_datos(:esquemaId1, :campo1, :esquemaId2, :campo2, :subdominioId, :definicionCampo)", nativeQuery = true)
    void insertarDatos(
            @Param("esquemaId1") Integer esquemaId1,
            @Param("campo1") String campo1,
            @Param("esquemaId2") Integer esquemaId2,
            @Param("campo2") String campo2,
            @Param("subdominioId") Integer subdominioId,
            @Param("definicionCampo") String definicionCampo
    );
}