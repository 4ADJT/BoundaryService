package br.com.fiap.boundaryservice.service;

import br.com.fiap.boundaryservice.model.entity.Notification;

import java.util.List;

public interface INotificationService {

  public List<Notification> getNotifications();

  public Notification getNotification(String id);

  public Notification createNotification(Notification notification);

  public Notification updateNotification(Notification notification);
}
