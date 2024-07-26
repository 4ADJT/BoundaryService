package br.com.fiap.boundaryservice.model.dto;

import java.time.Instant;
import java.time.LocalDateTime;

public record InvoiceDTO (

    String id,

    LocalDateTime InvoiceDate,

    double InvoiceAmount,

    Instant createdAt,

    Instant updatedAt

) {}
