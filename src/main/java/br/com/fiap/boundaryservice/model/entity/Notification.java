package br.com.fiap.boundaryservice.model.entity;

import br.com.fiap.boundaryservice.model.utils.NotificationENUM;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Document
@Data
public class Notification {

  @Id
  private String id;

  private String title;

  private String message;

  private List<NotificationENUM> sendChannel;

  private boolean confirmation;

  @CreatedDate
  private Instant createdAt;

  @LastModifiedDate
  private Instant updatedAt;

}
