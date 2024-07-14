package br.com.fiap.boundaryservice.model.dto;

import br.com.fiap.boundaryservice.model.utils.PaymentStatusENUM;
import br.com.fiap.boundaryservice.model.utils.PaymentTypeENUM;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record PaymentDTO(

    String id,

    @NotNull(message = "Test flag is required.")
    boolean test,

    @NotNull(message = "paid flag is required.")
    boolean paid,

    @NotNull(message = "Customer is required.")
    String customer,

    @NotNull(message = "Status is required.")
    PaymentStatusENUM status,

    @NotNull(message = "Customer is required.")
    PaymentTypeENUM type,

    @NotNull(message = "Payment date is required.")
    LocalDateTime paymentDate,

    @NotNull(message = "Value of payment is required.")
    double value,

    @NotNull
    LocalDateTime createPayment,

    LocalDateTime updatedDate
) {
}
