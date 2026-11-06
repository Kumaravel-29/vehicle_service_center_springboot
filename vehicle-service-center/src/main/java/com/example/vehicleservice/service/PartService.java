package com.example.vehicleservice.service;
import com.example.vehicleservice.entity.Part; import com.example.vehicleservice.dto.PartRequest; import com.example.vehicleservice.repository.PartRepository; import org.springframework.stereotype.Service;
@Service public class PartService {private final PartRepository repo; public PartService(PartRepository r){repo=r;} public Part create(PartRequest d){Part p=new Part();p.setName(d.name());p.setUnitPrice(d.unitPrice());p.setStock(d.stock());return repo.save(p);} public java.util.List<Part> available(){return repo.findAvailableParts(0);}}
