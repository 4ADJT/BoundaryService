package br.com.fiap.boundaryservice.model.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.LocalDateTime;

@Document
@Data
public class Invoice {

  @Id
  private String id;

  private double InvoiceAmount;

  @CreatedDate
  private Instant paymentDate;

}
