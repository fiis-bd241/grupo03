package com.example.bcp.repository;

import com.example.bcp.model.Prioridad;
import com.example.bcp.model.Programacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProgramacionRepository extends JpaRepository<Programacion, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO \"Programacion\"\n" +
            "(\"Migracion_Id\",\"FrecuenciaEjecucion\",\"DiaInicio\",\n" +
            "\"DiaFin\",\"ConsideracionFrecuencia\")\n" +
            "VALUES \n" +
            "(:migracionId,:frecuenciaEjecucion,:diaInicio,:diaFin,:consideracionFrecuencia) ;", nativeQuery = true)
    void asignarProgramacionAMigracion(@Param("migracionId") int migracionId,
                                    @Param("frecuenciaEjecucion") String frecuenciaEjecucion,
                                       @Param("diaInicio") String diaInicio,
                                       @Param("diaFin") String diaFin,
                                       @Param("consideracionFrecuencia") String consideracionFrecuencia);

}
