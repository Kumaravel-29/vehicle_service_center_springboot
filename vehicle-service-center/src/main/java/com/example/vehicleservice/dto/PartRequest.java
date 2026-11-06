package com.example.vehicleservice.dto;
import jakarta.validation.constraints.*; import java.math.BigDecimal;
public record PartRequest(@NotBlank String name,@NotNull @DecimalMin("0.0") BigDecimal unitPrice,@Min(0) int stock) {}
