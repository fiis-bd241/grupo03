package com.example.bcp.repository;
import com.example.bcp.model.Squad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SquadRepository extends JpaRepository<Squad, Long> {

    @Query(value = "SELECT id_squad, nombre_squad FROM public.\"Squad\"",
            nativeQuery = true)
    List<Object[]> todoSquads();
}
