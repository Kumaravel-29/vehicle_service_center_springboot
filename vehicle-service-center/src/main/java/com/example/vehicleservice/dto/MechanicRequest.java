package com.example.vehicleservice.dto;
import jakarta.validation.constraints.NotBlank;
public record MechanicRequest(@NotBlank String name,@NotBlank String specialization) {}
