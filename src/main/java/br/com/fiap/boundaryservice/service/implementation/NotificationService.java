package br.com.fiap.boundaryservice.service.implementation;

import br.com.fiap.boundaryservice.model.entity.Notification;
import br.com.fiap.boundaryservice.repository.INotificationRepository;
import br.com.fiap.boundaryservice.service.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class NotificationService implements INotificationService {
  private final INotificationRepository repository;

  @Autowired
  public NotificationService(INotificationRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<Notification> getNotifications() {
    return this.repository.findAll();
  }

  @Override
  public Notification getNotification(String id) {
    return this.repository
        .findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Notification not found"));
  }

  @Override
  public Notification createNotification(Notification notification) {
    return this.repository.save(notification);
  }

  @Override
  public Notification setConfirmation(String id) {
    Notification notification = this.repository
        .findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Notification not found"));

    notification.setConfirmation(!notification.isConfirmation());

    return this.repository.save(notification);
  }
}
