package br.com.fiap.boundaryservice.model.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.time.Instant;
import java.time.LocalDateTime;

@Document
@Data
public class Notification {

  @Id
  private String id;

  private String parkingId;

  private String title;

  private String message;

  private String email;

  private boolean confirmation;

  private BigInteger duration;

  private LocalDateTime expirationTime;

  @CreatedDate
  private Instant createdAt;

  @LastModifiedDate
  private Instant updatedAt;

  public Notification() {
    if(this.isConfirmation()) {
      return;
    }

    this.confirmation = false;
  }

}
