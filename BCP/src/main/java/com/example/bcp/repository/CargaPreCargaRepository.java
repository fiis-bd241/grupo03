package com.example.bcp.repository;

import com.example.bcp.model.CargaPreCarga;
import com.example.bcp.model.Modelado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CargaPreCargaRepository extends JpaRepository<CargaPreCarga, Long> {
}
