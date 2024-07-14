package br.com.fiap.boundaryservice.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
public class Notification {

  enum Channels {
    EMAIL, SMS, WHATSAPP, TELEGRAM
  }

  @Id
  private String id;

  private String title;

  private String message;

  private Channels[] sendChannel;

  private boolean confirmation;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

}
