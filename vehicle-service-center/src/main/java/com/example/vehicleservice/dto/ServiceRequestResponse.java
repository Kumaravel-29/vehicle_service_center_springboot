package com.example.vehicleservice.dto;
import java.time.LocalDateTime; import java.util.List;
public record ServiceRequestResponse(Long id,String registrationNumber,String vehicleModel,String mechanicName,String status,String description,List<String> parts,LocalDateTime createdAt) {}
