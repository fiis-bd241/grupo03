package com.example.bcp.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface CampoRepository {
    @Query(value = "SELECT *\n" +
            "FROM public.\"Modelado\" m\n" +
            "JOIN public.\"DefinicionesTecnicas\" dt ON \tm.\"id_referencia\" = dt.\"id_DT\"\n" +
            "JOIN public.\"ConceptosNegocio\" cn ON \tdt.\"EquivalenciaId\" = cn.\"id_referencia\"\n" +
            "JOIN public.\"Migracion\" mg ON mg.\"Migracion_Id\"=cn.\"MigracionId\"\n" +
            "WHERE mg.\"Pedido_Id\" =:pedidoId;", nativeQuery = true)
    List<Object[]> camposPorPedido(@Param("pedidoId") Integer pedidoId);
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO \"Campo\" (\"ID_Modelo\", \"id_TipodeDato\", \"id_AlgoritmoEnc\", \"id_AlgoritmoEnm\")\n" +
            "VALUES (\n" +
            "  (SELECT \"ID_Modelo\" FROM \"Modelado\" WHERE \"CampoDDV\" = :campoDDV),\n" +
            "  (SELECT \"id_TipoDeDato\" \n" +
            "   FROM \"TipoDato\" \n" +
            "   WHERE \"Nivel de acceso\" = :nivelDeAcceso\n" +
            "     AND \"Encriptación\" = :encriptacion\n" +
            "     AND \"Enmascarado\" = :enmascarado),\n" +
            "  null,\n" +
            "  null\n" +
            ");", nativeQuery = true)
    void crearCampo(@Param("nivelDeAcceso") String nivelDeAcceso,
                                    @Param("encriptacion") boolean encriptacion,
                    @Param("campoDDV") String campoDDV,
                                    @Param("enmascarado") boolean enmascarado);

}
