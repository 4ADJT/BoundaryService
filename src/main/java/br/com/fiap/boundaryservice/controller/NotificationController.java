package br.com.fiap.boundaryservice.controller;

import br.com.fiap.boundaryservice.model.entity.Notification;
import br.com.fiap.boundaryservice.service.implementation.NotificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/notification")
@Tag(name = "Notification")
public class NotificationController {
  private final NotificationService notificationService;

  @Autowired
  public NotificationController(NotificationService notificationService) {
    this.notificationService = notificationService;
  }

  @GetMapping
  @Operation(summary = "Get notifications records", description = "This route retrieves the notifications recorded at the boundary.")
  public List<Notification> getNotifications() {
    return this.notificationService.getNotifications();
  }

  @GetMapping("/{id}")
  @Operation(summary = "Get one payment record", description = "This route retrieves the notifications recorded by id at the boundary.")
  public Notification getNotificationById(@PathVariable("id") String id) {
    return this.notificationService.getNotification(id);
  }

  @PostMapping
  @Operation(summary = "Create one notification record", description = "This route creates a new notification.")
  public Notification createNotification(@RequestBody Notification notification) {
    return this.notificationService.createNotification(notification);
  }

  @PutMapping
  public Notification updateNotification(@RequestBody Notification notification) {
    return this.notificationService.updateNotification(notification);
  }

}
