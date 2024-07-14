package br.com.fiap.boundaryservice.model.dto;

import br.com.fiap.boundaryservice.model.utils.ChannelsENUM;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record NotificationDTO(

    String id,

    @NotBlank(message = "Tittle is required.")
    String title,

    @NotBlank(message = "Message is required.")
    String message,

    @NotEmpty(message = "Channels to send notification is required.")
    ChannelsENUM[] sendChannel,

    @NotNull(message = "Confirmation is required.")
    boolean confirmation,

    @NotNull(message = "Creation date is required.")
    LocalDateTime createdAt,

    LocalDateTime updatedAt

) {
}
