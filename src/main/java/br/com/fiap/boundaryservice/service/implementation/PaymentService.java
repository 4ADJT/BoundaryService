package br.com.fiap.boundaryservice.service.implementation;

import br.com.fiap.boundaryservice.model.Payment;
import br.com.fiap.boundaryservice.repository.IPaymentRepository;
import br.com.fiap.boundaryservice.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PaymentService implements IPaymentService {
  private final IPaymentRepository repository;

  @Autowired
  public PaymentService(IPaymentRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<Payment> getPayments() {
    return this.repository.findAll();
  }

  @Override
  public Payment getPayment(String id) {
    return this.repository
        .findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Payment not found"));
  }

  @Override
  public Payment createPayment(Payment payment) {
    return this.repository.save(payment);
  }
}
