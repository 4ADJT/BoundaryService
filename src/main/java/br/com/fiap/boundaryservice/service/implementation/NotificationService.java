package br.com.fiap.boundaryservice.service.implementation;

import br.com.fiap.boundaryservice.model.dto.NotificationDTO;
import br.com.fiap.boundaryservice.model.entity.Notification;
import br.com.fiap.boundaryservice.model.mapper.NotificationMapper;
import br.com.fiap.boundaryservice.repository.INotificationRepository;
import br.com.fiap.boundaryservice.service.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NotificationService implements INotificationService {
  private final INotificationRepository repository;
  private final NotificationMapper mapper;

  @Autowired
  public NotificationService(INotificationRepository repository, NotificationMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  @Override
  public Page<NotificationDTO> getNotifications(Pageable pageable) {

    Page<Notification> notifications = this.repository.findAll(pageable);

    return notifications.map(mapper::toDTO);
  }

  @Override
  public NotificationDTO getNotification(String id) {
    return mapper.toDTO(this.repository
        .findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Notification not found")));
  }

  @Override
  public NotificationDTO createNotification(NotificationDTO notificationDTO) {
    Notification notification = mapper.toEntity(notificationDTO);

    notification = this.repository.save(notification);

    return mapper.toDTO(notification);
  }

  @Override
  public NotificationDTO setConfirmation(String id) {
    Notification notification = this.repository
        .findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Notification not found"));

    notification.setConfirmation(!notification.isConfirmation());

    return mapper.toDTO(this.repository.save(notification));
  }
}
