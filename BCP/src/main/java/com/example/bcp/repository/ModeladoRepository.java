package com.example.bcp.repository;

import com.example.bcp.model.Modelado;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ModeladoRepository extends JpaRepository<Modelado, Long> {

    @Query(value = "SELECT dt.\"Campo\" AS \"Campo\", m.\"EsquemaDDV\",m.\"TablaDDV\", m.\"CampoDDV\", m.\"CampoLlave\",m.\"Campo_Descarta\" " +
            "FROM public.\"Modelado\" m " +
            "INNER JOIN public.\"DefinicionesTecnicas\" dt " +
            "ON m.\"id_referencia\" = dt.\"id_DT\"" +
            "WHERE dt.\"Campo\" = :campo ",
    nativeQuery = true)
    List<Object[]> findTodosModelos(@Param("campo") String campo);
    @Query(value = "SELECT m.\"CampoDDV\" AS \"CampoDDV\"\n" +
            "FROM public.\"Modelado\" m \n" +
            "INNER JOIN public.\"DefinicionesTecnicas\" dt\n" +
            "ON m.\"id_referencia\" = dt.\"id_DT\"\n" +
            "INNER JOIN public.\"ConceptosNegocio\" cn\n" +
            "ON cn.\"id_referencia\" = dt.\"EquivalenciaId\"\n" +
            "INNER JOIN public.\"Migracion\" mg\n" +
            "ON cn.\"MigracionId\"=mg.\"Migracion_Id\"\n" +
            "WHERE mg.\"Pedido_Id\"=:pedidoId",
            nativeQuery = true)
    List<Object[]> modeladoPorPedido(@Param("pedidoId") Integer pedidoId);
    @Query(value = "SELECT dt.\"Campo\" AS \"Campo\"\n" +
            "FROM public.\"DefinicionesTecnicas\" dt \n" +
            "INNER JOIN public.\"ConceptosNegocio\" cn\n" +
            "ON cn.\"id_referencia\" = dt.\"EquivalenciaId\"\n" +
            "INNER JOIN public.\"Migracion\" mg\n" +
            "ON cn.\"MigracionId\"=mg.\"Migracion_Id\"\n" +
            "WHERE mg.\"Pedido_Id\"=:pedidoId",
            nativeQuery = true)
    List<Object[]> deftecnicaPorPedido(@Param("pedidoId") Integer pedidoId);
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO public.\"Modelado\" (id_referencia, \"EsquemaDDV\",\"TablaDDV\",\"CampoDDV\",\"CampoLlave\",\"Campo_Descarta\") " +
            "SELECT \"id_DT\", NULL, NULL, :campoDDV, :campoLlave, :campoDescarta " +
            "FROM public.\"DefinicionesTecnicas\" " +
            "WHERE \"Campo\" = :campo ",
    nativeQuery = true)
    void insertarModelo(@Param("campoDDV") String campoDDV,
                        @Param("campoLlave") boolean campoLlave,
                        @Param("campoDescarta") boolean campoDescarta,
                        @Param("campo") String campo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE public.\"Modelado\" " +
            "SET \"EsquemaDDV\" = :esquemaDDV, \"TablaDDV\" = :tablaDDV " +
            "WHERE id_referencia = (SELECT \"id_DT\" FROM public.\"DefinicionesTecnicas\" " +
            "WHERE \"Campo\" = :campo) ",
    nativeQuery = true)
    void actualizarEsquemaTabla(@Param("esquemaDDV") String esquemaDDV,
                                @Param("tablaDDV") String tablaDDV,
                                @Param("campo") String campo);
}