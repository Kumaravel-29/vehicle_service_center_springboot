package com.example.vehicleservice.repository;
import com.example.vehicleservice.entity.Vehicle; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface VehicleRepository extends JpaRepository<Vehicle,Long> { List<Vehicle> findByCustomerId(Long customerId); Optional<Vehicle> findByRegistrationNumber(String registrationNumber); }
