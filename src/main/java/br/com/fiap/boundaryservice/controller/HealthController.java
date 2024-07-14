package br.com.fiap.boundaryservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class HealthController {
  private record BodyResponse(String status) {}
  private final BodyResponse bodyResponse;

  public HealthController() {
    this.bodyResponse = new BodyResponse("ok");
  }

  @GetMapping
  @Operation(hidden = true)
  public ResponseEntity<BodyResponse> health() {
    return ResponseEntity.status(HttpStatus.OK).body(bodyResponse);
  }

}
