package br.com.fiap.boundaryservice.service;

import br.com.fiap.boundaryservice.model.Payment;

import java.util.List;

public interface IPaymentService {

  public List<Payment> getPayments();

  public Payment getPayment(String id);

  public Payment createPayment(Payment payment);

}
