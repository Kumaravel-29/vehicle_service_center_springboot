package com.example.vehicleservice.repository;
import com.example.vehicleservice.entity.Invoice; import org.springframework.data.jpa.repository.JpaRepository; import java.util.Optional;
public interface InvoiceRepository extends JpaRepository<Invoice,Long> { Optional<Invoice> findByServiceRequestId(Long requestId); }
