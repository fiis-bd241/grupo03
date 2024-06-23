package com.example.bcp.repository;

import com.example.bcp.model.PreCarga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PreCargaRepository extends JpaRepository<PreCarga,Long> {
    @Query(value = "SELECT \"Nombre_Regla\" \n" +
            "FROM \"PreCarga\"\n" +
            "WHERE \"Obligatorio\" IS true;",
            nativeQuery = true)
    List<Object[]> reglasObligatorias();

    @Query(value = "SELECT \"Nombre_Regla\" \n" +
            "FROM \"PreCarga\"\n" +
            "WHERE \"Obligatorio\" IS false;",
            nativeQuery = true)
    List<Object[]> reglasOpcionales();
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO \"CargaPreCarga\"(\"ID_ReglaCarga\", \"ID_Precarga\")" +
            "VALUES (SELECT \"ID_ReglaCargaTecn\" FROM \"ReglaDeCargaTecnica\" \n" +
            "         WHERE \"regla_funcional\"= (SELECT \"ID_ReglaCargaFunc\" \n" +
            "                                 FROM \"ReglaDeCargaFuncional\" rfun \n" +
            "                                 WHERE  rfun.\"id_migracion\"=:migracionId)), SELECT \"ID_Precarga\" FROM \"PreCarga\" pre \n" +
            "                                                                     WHERE pre.\"Nombre_Regla\" = :nombreRegla)", nativeQuery = true)
    void relacionarCargaPrecarga(@Param("migracionId") int migracionId, @Param("nombreRegla") String nombreRegla);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO \"CargaPreCarga\"\n" +
            " VALUES((SELECT rct.\"ID_ReglaCargaTecn\" \n" +
            "         FROM \"ReglaDeCargaTecnica\" rct \n" +
            "         INNER JOIN \"ReglaDeCargaFuncional\" rcf\n" +
            "         ON rct. \"regla_funcional\"=rcf. \"ID_ReglaCargaFunc\"\n" +
            "         WHERE rcf. \"id_migracion\"=(SELECT modl.\"ID_Modelo\"\n" +
            "                                 FROM \"Modelado\" modl   \n" +
            "                                 WHERE modl. \"CampoLlave\" IS true)),(SELECT \"ID_Precarga\" FROM \"PreCarga\" pre \n" +
            "                                                                     WHERE pre.\"Nombre_Regla\" = :nombreRegla))", nativeQuery = true)
    void reglaDeCargaObligatoria(@Param("nombreRegla") String nombreRegla);
}
