package com.example.vehicleservice.repository;
import com.example.vehicleservice.entity.*; import org.springframework.data.jpa.repository.*; import org.springframework.data.repository.query.Param; import org.springframework.data.domain.*; import java.util.*;
public interface ServiceRequestRepository extends JpaRepository<ServiceRequest,Long> {
 List<ServiceRequest> findByVehicleCustomerIdOrderByCreatedAtDesc(Long customerId);
 Page<ServiceRequest> findByStatus(ServiceStatus status,Pageable pageable);
 @Query("select sr from ServiceRequest sr join sr.vehicle v where v.id=:vehicleId order by sr.createdAt desc") List<ServiceRequest> historyForVehicle(@Param("vehicleId") Long vehicleId);
 @Query(value="SELECT * FROM service_requests WHERE status = :status",nativeQuery=true) List<ServiceRequest> findByStatusNative(@Param("status") String status);
}
