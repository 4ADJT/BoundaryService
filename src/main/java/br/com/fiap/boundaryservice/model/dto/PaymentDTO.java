package br.com.fiap.boundaryservice.model.dto;

import br.com.fiap.boundaryservice.model.entity.Invoice;
import br.com.fiap.boundaryservice.model.entity.action.Card;
import br.com.fiap.boundaryservice.model.entity.action.Pix;
import br.com.fiap.boundaryservice.model.utils.PaymentStatusENUM;
import br.com.fiap.boundaryservice.model.utils.PaymentTypeENUM;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.time.Instant;
import java.time.LocalDateTime;

public record PaymentDTO(

    String id,

    @NotNull(message = "Customer id is required.")
    String customerId,

    boolean paid,

    PaymentStatusENUM status,

    @NotNull(message = "Payment type is required.")
    PaymentTypeENUM type,

    @NotNull(message = "Payment date is required.")
    LocalDateTime paymentDate,

    @NotNull(message = "Value of payment is required.")
    double value,

    Pix pix,

    Card card,

    Invoice invoice,

    Instant createdAt,

    Instant updatedAt
) {
}
