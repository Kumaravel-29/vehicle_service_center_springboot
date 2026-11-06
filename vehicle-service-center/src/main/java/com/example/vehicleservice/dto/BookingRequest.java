package com.example.vehicleservice.dto;
import jakarta.validation.constraints.NotNull; import jakarta.validation.constraints.NotBlank; import java.util.List;
public record BookingRequest(@NotNull Long vehicleId,@NotBlank String description,List<Long> partIds) {}
