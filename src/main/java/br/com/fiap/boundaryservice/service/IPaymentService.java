package br.com.fiap.boundaryservice.service;

import br.com.fiap.boundaryservice.model.dto.PaymentDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IPaymentService {

  public Page<PaymentDTO> getPayments(Pageable pageable);

  public PaymentDTO getPayment(String id);

  public PaymentDTO createPayment(PaymentDTO paymentDTO);

}
