package com.example.vehicleservice.entity;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import java.util.*;
@Entity @Table(name="service_requests")
public class ServiceRequest {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(fetch=FetchType.LAZY,optional=false) private Vehicle vehicle;
 @ManyToOne(fetch=FetchType.LAZY) private Mechanic mechanic;
 @ManyToMany @JoinTable(name="service_request_parts",joinColumns=@JoinColumn(name="request_id"),inverseJoinColumns=@JoinColumn(name="part_id")) private List<Part> parts=new ArrayList<>();
 @Enumerated(EnumType.STRING) private ServiceStatus status=ServiceStatus.BOOKED;
 private String description; private LocalDateTime createdAt=LocalDateTime.now();
 @JsonIgnore @OneToOne(mappedBy="serviceRequest",cascade=CascadeType.ALL) private Invoice invoice;
 public Long getId(){return id;} public void setId(Long v){id=v;} public Vehicle getVehicle(){return vehicle;} public void setVehicle(Vehicle v){vehicle=v;}
 public Mechanic getMechanic(){return mechanic;} public void setMechanic(Mechanic v){mechanic=v;} public List<Part> getParts(){return parts;} public void setParts(List<Part> v){parts=v;}
 public ServiceStatus getStatus(){return status;} public void setStatus(ServiceStatus v){status=v;} public String getDescription(){return description;} public void setDescription(String v){description=v;}
 public LocalDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(LocalDateTime v){createdAt=v;} public Invoice getInvoice(){return invoice;} public void setInvoice(Invoice v){invoice=v;}
}
