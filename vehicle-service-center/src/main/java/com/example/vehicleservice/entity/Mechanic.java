package com.example.vehicleservice.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
@Entity @Table(name="mechanics")
public class Mechanic {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank private String name; @NotBlank private String specialization; private boolean available=true;
 public Long getId(){return id;} public void setId(Long v){id=v;} public String getName(){return name;} public void setName(String v){name=v;}
 public String getSpecialization(){return specialization;} public void setSpecialization(String v){specialization=v;}
 public boolean isAvailable(){return available;} public void setAvailable(boolean v){available=v;}
}
