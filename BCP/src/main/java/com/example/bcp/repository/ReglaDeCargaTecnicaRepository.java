package com.example.bcp.repository;

import com.example.bcp.model.ReglaDeCargaFuncional;
import com.example.bcp.model.ReglaDeCargaTecnica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository

public interface ReglaDeCargaTecnicaRepository extends JpaRepository<ReglaDeCargaTecnica,Long> {
    @Modifying
    @Transactional
    @Query(value =
            "INSERT INTO \"ReglaDeCargaTecnica\"(\"regla_funcional\",\"Codigo\",\"Finalizado\",\"Fecha\")\n" +
            "VALUES((SELECT \"ID_ReglaCargaFunc\" FROM \"ReglaDeCargaFuncional\" rfun\n" +
            "WHERE  rfun.\"id_migracion\"=:migracionId),:codigo,false,CURRENT_DATE);", nativeQuery = true)
    void enviarReglaParaRevision(@Param("migracionId") int migracionId,
                                    @Param("codigo") String codigo);
    @Modifying
    @Transactional
    @Query(value =
            "UPDATE \"ReglaDeCargaTecnica\"\n" +
                    "SET \"Codigo\"= :codigo,\n" +
                    "\"Fecha\"=CURRENT_DATE\n" +
                    "WHERE \"regla_funcional\"= (SELECT \"ID_ReglaCargaFunc\" FROM \"ReglaDeCargaFuncional\" rfun\n" +
                    "WHERE  rfun.\"id_migracion\"=:migracionId);\n", nativeQuery = true)
    void actualizarReglaParaRevision(@Param("migracionId") int migracionId,
                                 @Param("codigo") String codigo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE \"ReglaDeCargaTecnica\" \n" +
            "SET \"Finalizado\"=true,\n" +
            "\"Comentario\"=:comentario,\n" +
            "\"Fecha\"=CURRENT_DATE\n" +
            "WHERE \"regla_funcional\"= (SELECT \"ID_ReglaCargaFunc\" FROM \"ReglaDeCargaFuncional\" rfun\n" +
            "WHERE  rfun.\"id_migracion\"=:migracionId)", nativeQuery = true)
    void finalizarReglaDeCarga(@Param("migracionId") int migracionId,
                                 @Param("comentario") String comentario);
    @Modifying
    @Transactional
    @Query(value = "UPDATE \"ReglaDeCargaTecnica\" \n" +
            "SET \"Comentario\"=:comentario,\n" +
            "\"Finalizado\"=false,\n" +
            "\"Fecha\"=CURRENT_DATE\n" +
            "WHERE \"regla_funcional\"= (SELECT \"ID_ReglaCargaFunc\" \n" +
            "FROM \"ReglaDeCargaFuncional\" rfun \n" +
            "WHERE  rfun.\"id_migracion\"=:migracionId)", nativeQuery = true)
    void corregirReglaeDeCarga(@Param("migracionId") int migracionId,
                               @Param("comentario") String comentario);

}
