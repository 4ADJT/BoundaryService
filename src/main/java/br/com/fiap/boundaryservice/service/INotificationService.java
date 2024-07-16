package br.com.fiap.boundaryservice.service;

import br.com.fiap.boundaryservice.model.dto.NotificationDTO;
import br.com.fiap.boundaryservice.model.entity.Notification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface INotificationService {

  public Page<NotificationDTO> getNotifications(Pageable pageable);

  public Notification getNotification(String id);

  public NotificationDTO createNotification(NotificationDTO notificationDTO);

  public Notification setConfirmation(String id);
}
