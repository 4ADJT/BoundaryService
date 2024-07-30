package br.com.fiap.boundaryservice.model.entity;

import br.com.fiap.boundaryservice.model.entity.action.Card;
import br.com.fiap.boundaryservice.model.entity.action.Pix;
import br.com.fiap.boundaryservice.model.utils.PaymentStatusENUM;
import br.com.fiap.boundaryservice.model.utils.PaymentTypeENUM;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.LocalDateTime;

@Document
@Data
public class Payment {

  @Id
  private String id;

  private String customerId;

  private boolean paid;

  private PaymentStatusENUM status;

  private PaymentTypeENUM type;

  private double value;

  private Pix pix;

  private Card card;

  @DBRef
  private Invoice invoice;

  @CreatedDate
  private Instant createdAt;

  @LastModifiedDate
  private Instant updatedAt;

}
