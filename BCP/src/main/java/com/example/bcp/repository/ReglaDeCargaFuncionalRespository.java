package com.example.bcp.repository;

import com.example.bcp.model.PreCarga;
import com.example.bcp.model.ReglaDeCargaFuncional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository

public interface ReglaDeCargaFuncionalRespository extends JpaRepository<ReglaDeCargaFuncional,Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO \"ReglaDeCargaFuncional\"(\"id_migracion\",\"id_tecnologia\",\"Logica\",\"Fecha\")\n" +
            "VALUES(:migracionId,:tecnologiaId,:logica,CURRENT_DATE)", nativeQuery = true)
    void crearRegladeCargaFuncional(@Param("migracionId") int migracionId,
                                    @Param("tecnologiaId") int tecnologiaId,
                                    @Param("logica") String logica);
    @Query(value = " SELECT \"Logica\" FROM \"ReglaDeCargaFuncional\" rfun\n" +
            "WHERE rfun.\"id_migracion\"=:migracionId", nativeQuery = true)
    List<Object[]> buscarReglaFuncPorMigracion(@Param("migracionId") Integer migracionId);
}

