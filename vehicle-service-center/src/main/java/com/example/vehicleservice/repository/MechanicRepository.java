package com.example.vehicleservice.repository;
import com.example.vehicleservice.entity.Mechanic; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface MechanicRepository extends JpaRepository<Mechanic,Long> { List<Mechanic> findByAvailableTrue(); }
