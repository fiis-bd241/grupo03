package com.example.bcp.repository;

import com.example.bcp.model.TipoRecordatorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoRecordatorioRepository extends JpaRepository<TipoRecordatorio, Long> {
}
