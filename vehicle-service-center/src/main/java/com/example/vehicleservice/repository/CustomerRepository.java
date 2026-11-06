package com.example.vehicleservice.repository;
import com.example.vehicleservice.entity.Customer; import org.springframework.data.jpa.repository.JpaRepository; import java.util.Optional;
public interface CustomerRepository extends JpaRepository<Customer,Long> { Optional<Customer> findByEmail(String email); }
