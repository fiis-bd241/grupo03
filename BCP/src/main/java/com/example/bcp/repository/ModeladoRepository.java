package com.example.bcp.repository;

import com.example.bcp.model.Modelado;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ModeladoRepository extends JpaRepository<Modelado, Long> {

    @Query(value = "SELECT dt.\"Campo\" AS \"Campo\", m.\"EsquemaDDV\",m.\"TablaDDV\", m.\"CampoDDV\", m.\"CampoLlave\",m.\"Campo_Descarta\" " +
            "FROM public.\"Modelado\" m " +
            "INNER JOIN public.\"DefinicionesTecnicas\" dt " +
            "ON m.\"id_referencia\" = dt.\"id_DT\"" +
            "WHERE dt.\"Campo\" = :campo ",
    nativeQuery = true)
    List<Object[]> findTodosModelos(@Param("campo") String campo);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO public.\"Modelado\" (id_referencia, \"EsquemaDDV\",\"TablaDDV\",\"CampoDDV\",\"CampoLlave\",\"Campo_Descarta\")" +
            "SELECT \"id_DT\", NULL, NULL, :campoDDV, :campoLlave, :campoDescarta " +
            "FROM public.\"DefinicionesTecnicas\"" +
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