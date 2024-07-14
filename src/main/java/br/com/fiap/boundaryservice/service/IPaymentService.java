package br.com.fiap.boundaryservice.service;

import br.com.fiap.boundaryservice.model.dto.PaymentDTO;
import br.com.fiap.boundaryservice.model.entity.Payment;

import java.util.List;

public interface IPaymentService {

  public List<Payment> getPayments();

  public Payment getPayment(String id);

  public PaymentDTO createPayment(PaymentDTO paymentDTO);

}
