package br.com.fiap.boundaryservice.service;

import br.com.fiap.boundaryservice.model.dto.PaymentDTO;
import br.com.fiap.boundaryservice.model.entity.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPaymentService {

  public Page<PaymentDTO> getPayments(Pageable pageable);

  public Payment getPayment(String id);

  public PaymentDTO createPayment(PaymentDTO paymentDTO);

}
