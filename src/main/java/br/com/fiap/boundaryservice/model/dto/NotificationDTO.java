package br.com.fiap.boundaryservice.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigInteger;
import java.time.Instant;

import java.time.LocalDateTime;

public record NotificationDTO(

    String id,

    @NotNull(message = "Parking id is required.")
    String parkingId,

    @NotBlank(message = "Tittle is required.")
    String title,

    @NotBlank(message = "Message is required.")
    String message,

    @Email
    String email,

    @NotNull(message = "Confirmation is required.")
    boolean confirmation,

    BigInteger duration,

    LocalDateTime expirationTime,

    Instant created_at,

    Instant updated_at

) {
}
