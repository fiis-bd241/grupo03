package com.example.bcp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bcp.model.Notificacion;

public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {
}
