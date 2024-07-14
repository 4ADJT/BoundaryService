package br.com.fiap.boundaryservice.model;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
public class Payment {

  private enum PaymentStatus {
    PAID, ERROR, PROCESSING, REFUND, CANCELED, CHARGEBACK
  }

  private enum PaymentType {
    PIX, CREDIT, DEBIT
  }

  @Id
  private String id;

  private boolean test;

  private boolean paid;

  private LocalDateTime createPayment;

  private LocalDateTime updatedDate;

  private String customer;

  private PaymentStatus status;

  private PaymentType type;

  private double value;

  @CPF
  private String cpf;
}
