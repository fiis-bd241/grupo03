package com.example.bcp.repository;

import com.example.bcp.model.DefinicionesTecnicas;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DefinicionesTecnicasRepository extends JpaRepository<DefinicionesTecnicas, Long> {

    @Query(value = "SELECT \"Campo\" FROM public.\"DefinicionesTecnicas\" WHERE \"EquivalenciaId\" IS NULL",
    nativeQuery = true)
    List<Object[]> getCamposReferenciafromDT();

    @Query(value = "SELECT DISTINCT \"Tabla\" FROM public.\"DefinicionesTecnicas\" WHERE \"EquivalenciaId\" IS NULL",
    nativeQuery = true)
    List<String> findTablasReferencia();

    @Query(value = "SELECT DISTINCT e1.nombre_esquema AS \"Esquema Original\", e2.nombre_esquema AS \"EsquemaEquivalente\" " +
    "FROM public.\"DefinicionesTecnicas\" dt1 " +
    "LEFT JOIN public.\"DefinicionesTecnicas\" dt2 ON dt1.\"id_DT\" = dt2.\"EquivalenciaId\" "+
    "LEFT JOIN public.\"Esquema\" e1 ON dt1.\"EsquemaId\" = e1.\"id_esquema\" "+
    "LEFT JOIN public.\"Esquema\" e2 ON dt2.\"EsquemaId\" = e2.\"id_esquema\" " +
    "WHERE dt1.\"Tabla\" = :tabla ",
    nativeQuery = true)
    List<Object[]> findEsquemasOR(@Param("tabla") String tabla);

    @Query(value = "SELECT DISTINCT dt1.\"Tabla\" AS \"Tabla Original\", dt2.\"Tabla\" AS \"Tabla Equivalente\" " +
            "FROM public.\"DefinicionesTecnicas\" dt1 " +
            "LEFT JOIN public.\"DefinicionesTecnicas\" dt2 ON dt1.\"id_DT\" = dt2.\"EquivalenciaId\"" +
            "WHERE dt1.\"Tabla\" = :tabla ",
    nativeQuery = true)
    List<Object[]> findTablasOR(@Param("tabla") String tabla);

    @Query(value = "SELECT dt1.\"Campo\" AS \"Campo Original\", dt2.\"Campo\" AS \"Campo Equivalente\" " +
            "FROM public.\"DefinicionesTecnicas\" dt1 " +
            "LEFT JOIN public.\"DefinicionesTecnicas\" dt2 ON dt1.\"id_DT\" = dt2.\"EquivalenciaId\" " +
            "WHERE dt1.\"Tabla\" = :tabla ",
    nativeQuery = true)
    List<Object[]> findCamposOR(@Param("tabla") String tabla);

    @Query(value = "SELECT \"Campo\" FROM public.\"DefinicionesTecnicas\" WHERE \"EquivalenciaId\" IS NOT NULL ",
    nativeQuery = true)
    List<String> findCamposEquivalentes();

    @Modifying
    @Transactional
    @Query(value = "UPDATE public.\"DefinicionesTecnicas\" " +
            "SET \"Tabla\" = :tabla " +
            "WHERE \"EquivalenciaId\" = (SELECT \"id_DT\" " +
            "FROM public.\"DefinicionesTecnicas\"" +
            "WHERE \"Campo\" = :campo) ",
    nativeQuery = true)
    void actualizarTablaEquivalente(@Param("tabla") String tabla, @Param("campo") String campo);
}