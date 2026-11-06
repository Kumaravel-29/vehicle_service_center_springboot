package com.example.vehicleservice.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
@Entity @Table(name="vehicles")
public class Vehicle {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank @Column(unique=true) private String registrationNumber;
 @NotBlank private String brand; @NotBlank private String model;
 @ManyToOne(fetch=FetchType.EAGER,optional=false) @JoinColumn(name="customer_id") private Customer customer;
 public Long getId(){return id;} public void setId(Long id){this.id=id;}
 public String getRegistrationNumber(){return registrationNumber;} public void setRegistrationNumber(String v){registrationNumber=v;}
 public String getBrand(){return brand;} public void setBrand(String v){brand=v;}
 public String getModel(){return model;} public void setModel(String v){model=v;}
 public Customer getCustomer(){return customer;} public void setCustomer(Customer v){customer=v;}
}
