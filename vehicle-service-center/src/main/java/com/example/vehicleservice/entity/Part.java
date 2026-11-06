package com.example.vehicleservice.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
@Entity @Table(name="parts")
public class Part {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank private String name; @NotNull @DecimalMin("0.0") private BigDecimal unitPrice;
 @Min(0) private int stock;
 public Long getId(){return id;} public void setId(Long v){id=v;} public String getName(){return name;} public void setName(String v){name=v;}
 public BigDecimal getUnitPrice(){return unitPrice;} public void setUnitPrice(BigDecimal v){unitPrice=v;} public int getStock(){return stock;} public void setStock(int v){stock=v;}
}
