package br.com.fiap.boundaryservice.controller;

import br.com.fiap.boundaryservice.model.dto.PaymentDTO;

import br.com.fiap.boundaryservice.service.IPaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping(value = "/payment")
@Tag(name = "Payments")
public class PaymentController {
  private final IPaymentService paymentService;

  @Autowired
  public PaymentController(IPaymentService paymentService) {
    this.paymentService = paymentService;
  }

  @GetMapping
  @Operation(summary = "Get payment record", description = "This route retrieves the payments recorded at the boundary.")
  public Page<PaymentDTO> getPayments(
      @PageableDefault(size = 10, page = 0, sort = "createPayment", direction = Sort.Direction.DESC) Pageable pageable
  ) {
    return this.paymentService.getPayments(pageable);
  }

  @GetMapping("/{id}")
  @Operation(summary = "Get one payment record", description = "This route retrieves the payments recorded by id at the boundary.")
  public PaymentDTO getPaymentById(@PathVariable("id") String id) {
    return this.paymentService.getPayment(id);
  }

  @PostMapping
  @Operation(summary = "Create one payment record", description = "This route creates a new payment.")
  public ResponseEntity<PaymentDTO> createPayment(@Valid @RequestBody PaymentDTO paymentDTO) {
    PaymentDTO paymentSaved = this.paymentService.createPayment(paymentDTO);

    return ResponseEntity.status(HttpStatus.CREATED).body(paymentSaved);
  }

}
