package br.com.fiap.boundaryservice.controller;

import br.com.fiap.boundaryservice.model.dto.NotificationDTO;
import br.com.fiap.boundaryservice.model.entity.Notification;
import br.com.fiap.boundaryservice.service.implementation.NotificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;


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
  public Page<NotificationDTO> getNotifications(
      @PageableDefault(size = 10, page = 0, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable
  ) {
    return this.notificationService.getNotifications(pageable);
  }

  @GetMapping("/{id}")
  @Operation(summary = "Get one payment record", description = "This route retrieves the notifications recorded by id at the boundary.")
  public Notification getNotificationById(@PathVariable("id") String id) {
    return this.notificationService.getNotification(id);
  }

  @PostMapping
  @Operation(summary = "Create one notification record", description = "This route creates a new notification.")
  public NotificationDTO createNotification(@RequestBody NotificationDTO notificationDTO) {
    return this.notificationService.createNotification(notificationDTO);
  }

  @PutMapping("/{id}")
  public Notification updateNotification(@PathVariable("id") String id) {
    return this.notificationService.setConfirmation(id);
  }

}
