package com.example.vehicleservice.dto;
import jakarta.validation.constraints.*;
public record CustomerRequest(@NotBlank String name,@Email @NotBlank String email,@NotBlank String phone) {}
