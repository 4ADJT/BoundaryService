package br.com.fiap.boundaryservice.model.dto;

import br.com.fiap.boundaryservice.model.utils.NotificationENUM;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

import java.util.List;

public record NotificationDTO(

    String id,

    @NotBlank(message = "Tittle is required.")
    String title,

    @NotBlank(message = "Message is required.")
    String message,

    String email,

    String cellphone,

    @NotEmpty(message = "Channels to send notification is required.")
    List<NotificationENUM> send_channels,

    @NotNull(message = "Confirmation is required.")
    boolean confirmation,

    Instant created_at,

    Instant updated_at

) {
}
