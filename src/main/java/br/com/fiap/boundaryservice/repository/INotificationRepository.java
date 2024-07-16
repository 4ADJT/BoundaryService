package br.com.fiap.boundaryservice.repository;

import br.com.fiap.boundaryservice.model.entity.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface INotificationRepository extends MongoRepository<Notification, String> {
}