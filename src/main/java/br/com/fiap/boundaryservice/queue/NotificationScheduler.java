package br.com.fiap.boundaryservice.queue;

import br.com.fiap.boundaryservice.model.entity.Notification;
import br.com.fiap.boundaryservice.repository.INotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class NotificationScheduler {

  private final INotificationRepository repository;

  @Autowired
  public NotificationScheduler(INotificationRepository repository) {
    this.repository = repository;
  }

  @Scheduled(fixedRate = 30000)
  public void scheduleNotification() {
    LocalDateTime now = LocalDateTime.now();

    System.out.println("\n -> Queue em execução \n");

    List<Notification> notifications = repository.findAll();

    notifications.stream()
        .filter(notification -> !notification.isConfirmation())
        .filter(notification -> notification.getExpirationTime().isBefore(now) || notification.getExpirationTime().isEqual(now))
        .map(notification -> {
          notification.setConfirmation(true);

          repository.save(notification);
          return notification;
        })
        .forEach(notification -> System.out.println("\n --> Notificação enviada para o Parking Id" + notification.getParkingId() + "\n"));

  }

}
