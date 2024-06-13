package com.example.bcp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bcp.model.Area;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {

    @Query(value = "SELECT \"Area_Id\", \"Area_Nombre\" FROM public.\"Area\"",
            nativeQuery = true)
    List<Object[]> todoAreas();
}
