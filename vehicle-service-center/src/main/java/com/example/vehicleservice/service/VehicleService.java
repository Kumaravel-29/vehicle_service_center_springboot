package com.example.vehicleservice.service;
import com.example.vehicleservice.entity.*; import com.example.vehicleservice.repository.*; import com.example.vehicleservice.dto.*; import com.example.vehicleservice.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional; import java.util.*;
@Service public class VehicleService {
 private final VehicleRepository vehicles; private final CustomerRepository customers;
 public VehicleService(VehicleRepository v,CustomerRepository c){vehicles=v;customers=c;}
 @Transactional public Vehicle create(VehicleRequest r){Customer c=customers.findById(r.customerId()).orElseThrow(()->new ResourceNotFoundException("Customer not found")); Vehicle v=new Vehicle();v.setRegistrationNumber(r.registrationNumber());v.setBrand(r.brand());v.setModel(r.model());v.setCustomer(c);return vehicles.save(v);}
 public List<Vehicle> all(){return vehicles.findAll();}
}
