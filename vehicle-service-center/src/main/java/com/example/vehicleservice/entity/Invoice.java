package com.example.vehicleservice.entity;
import jakarta.persistence.*;
import java.math.BigDecimal; import java.time.LocalDateTime;
@Entity @Table(name="invoices")
public class Invoice {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(unique=true) private String invoiceNumber; private BigDecimal totalAmount; private LocalDateTime issuedAt=LocalDateTime.now();
 @OneToOne(fetch=FetchType.LAZY) @JoinColumn(name="service_request_id",unique=true) private ServiceRequest serviceRequest;
 public Long getId(){return id;} public void setId(Long v){id=v;} public String getInvoiceNumber(){return invoiceNumber;} public void setInvoiceNumber(String v){invoiceNumber=v;}
 public BigDecimal getTotalAmount(){return totalAmount;} public void setTotalAmount(BigDecimal v){totalAmount=v;} public LocalDateTime getIssuedAt(){return issuedAt;} public void setIssuedAt(LocalDateTime v){issuedAt=v;}
 public ServiceRequest getServiceRequest(){return serviceRequest;} public void setServiceRequest(ServiceRequest v){serviceRequest=v;}
}
