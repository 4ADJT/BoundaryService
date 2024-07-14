package br.com.fiap.boundaryservice.controller;

import br.com.fiap.boundaryservice.model.entity.Payment;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/notification")
@Tag(name = "Payments")
public class NotificationController {

  @GetMapping
  @Operation(summary = "Get notifications records", description = "This route retrieves the notifications recorded at the boundary.")
  public List<Payment> getNotifications() {
    return null;
  }

  @GetMapping("/{id}")
  @Operation(summary = "Get one payment record", description = "This route retrieves the notifications recorded by id at the boundary.")
  public Payment getNotificationById(@PathVariable String id) {
    return null;
  }

  @PostMapping
  @Operation(summary = "Create one notification record", description = "This route creates a new notification.")
  public Payment createNotification() {
    return null;
  }

}
