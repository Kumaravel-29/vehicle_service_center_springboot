package com.example.vehicleservice.dto;
import jakarta.validation.constraints.NotBlank; import jakarta.validation.constraints.NotNull;
public record VehicleRequest(@NotBlank String registrationNumber,@NotBlank String brand,@NotBlank String model,@NotNull Long customerId) {}
