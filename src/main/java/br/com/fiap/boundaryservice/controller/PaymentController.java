package br.com.fiap.boundaryservice.controller;

import br.com.fiap.boundaryservice.model.Payment;
import br.com.fiap.boundaryservice.service.IPaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

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
  public List<Payment> getPayments() {
    return this.paymentService.getPayments();
  }

  @GetMapping("/{id}")
  @Operation(summary = "Get one payment record", description = "This route retrieves the payments recorded by id at the boundary.")
  public Payment getPaymentById(@PathVariable String id) {
    return this.paymentService.getPayment(id);
  }

  @PostMapping
  @Operation(summary = "Create one payment record", description = "This route creates a new payment.")
  public Payment createPayment(@RequestBody Payment payment) {
    return this.paymentService.createPayment(payment);
  }

}
