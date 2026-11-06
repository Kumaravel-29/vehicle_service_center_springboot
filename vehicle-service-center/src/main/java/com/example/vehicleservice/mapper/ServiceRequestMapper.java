package com.example.vehicleservice.mapper;
import com.example.vehicleservice.entity.ServiceRequest; import com.example.vehicleservice.dto.ServiceRequestResponse; import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
@Component public class ServiceRequestMapper {
 public ServiceRequestResponse toResponse(ServiceRequest r) { return new ServiceRequestResponse(r.getId(),r.getVehicle().getRegistrationNumber(),r.getVehicle().getBrand()+" "+r.getVehicle().getModel(),r.getMechanic()==null?null:r.getMechanic().getName(),r.getStatus().name(),r.getDescription(),r.getParts().stream().map(p->p.getName()).collect(Collectors.toList()),r.getCreatedAt()); }
}
