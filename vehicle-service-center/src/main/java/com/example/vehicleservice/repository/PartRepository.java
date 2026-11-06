package com.example.vehicleservice.repository;
import com.example.vehicleservice.entity.Part; import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.data.jpa.repository.Query; import org.springframework.data.repository.query.Param; import java.util.*;
public interface PartRepository extends JpaRepository<Part,Long> { @Query("select p from Part p where p.stock > :minimum order by p.name") List<Part> findAvailableParts(@Param("minimum") int minimum); }
