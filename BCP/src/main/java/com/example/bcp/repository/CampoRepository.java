package com.example.bcp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.bcp.model.Campo;

import java.util.List;

@Repository
public interface CampoRepository extends JpaRepository<Campo, Integer> {

    @Query(value = "SELECT * FROM public.\"Modelado\" m " +
            "JOIN public.\"DefinicionesTecnicas\" dt ON m.\"id_referencia\" = dt.\"id_DT\" " +
            "JOIN public.\"ConceptosNegocio\" cn ON dt.\"EquivalenciaId\" = cn.\"id_referencia\" " +
            "JOIN public.\"Migracion\" mg ON mg.\"Migracion_Id\"=cn.\"MigracionId\" " +
            "WHERE mg.\"Pedido_Id\" = :pedidoId", nativeQuery = true)
    List<Object[]> camposPorPedido(@Param("pedidoId") Integer pedidoId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO \"Campo\" (\"ID_Modelo\", \"id_TipodeDato\", \"id_AlgoritmoEnc\", \"id_AlgoritmoEnm\") " +
            "VALUES ( " +
            "  (SELECT \"ID_Modelo\" FROM \"Modelado\" WHERE \"CampoDDV\" = :campoDDV), " +
            "  (SELECT \"id_TipoDeDato\" FROM \"TipoDato\" WHERE \"Nivel de acceso\" = :nivelDeAcceso " +
            "    AND \"Encriptación\" = :encriptacion AND \"Enmascarado\" = :enmascarado), " +
            "  null, " +
            "  null)", nativeQuery = true)
    void crearCampo(@Param("nivelDeAcceso") String nivelDeAcceso,
                    @Param("encriptacion") boolean encriptacion,
                    @Param("campoDDV") String campoDDV,
                    @Param("enmascarado") boolean enmascarado);
}
