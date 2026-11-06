package com.example.vehicleservice.controller;
import com.example.vehicleservice.dto.*; import com.example.vehicleservice.entity.*; import com.example.vehicleservice.service.ServiceRequestService; import jakarta.validation.Valid; import org.springframework.http.*; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/service-requests") public class ServiceRequestController {private final ServiceRequestService service;public ServiceRequestController(ServiceRequestService s){service=s;}
 @PostMapping public ResponseEntity<ServiceRequestResponse> book(@Valid @RequestBody BookingRequest d){return ResponseEntity.status(HttpStatus.CREATED).body(service.book(d));}
 @PutMapping("/{id}/mechanic/{mechanicId}") public ResponseEntity<?> assign(@PathVariable Long id,@PathVariable Long mechanicId){return ResponseEntity.ok(service.assignMechanic(id,mechanicId));}
 @PatchMapping("/{id}/status") public ResponseEntity<?> status(@PathVariable Long id,@RequestParam ServiceStatus value){return ResponseEntity.ok(service.updateStatus(id,value));}
 @GetMapping("/vehicle/{vehicleId}/history") public ResponseEntity<?> history(@PathVariable Long vehicleId){return ResponseEntity.ok(service.history(vehicleId));}
 @GetMapping public ResponseEntity<?> page(@RequestParam ServiceStatus status,@RequestParam(defaultValue="0") int page,@RequestParam(defaultValue="10") int size,@RequestParam(defaultValue="createdAt") String sortBy){return ResponseEntity.ok(service.page(status,page,size,sortBy));}
 @PostMapping("/{id}/invoice") public ResponseEntity<?> invoice(@PathVariable Long id){return ResponseEntity.status(HttpStatus.CREATED).body(service.createInvoice(id));}
}
