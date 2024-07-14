package br.com.fiap.boundaryservice.service.implementation;

import br.com.fiap.boundaryservice.model.dto.PaymentDTO;
import br.com.fiap.boundaryservice.model.entity.Payment;
import br.com.fiap.boundaryservice.model.mapper.PaymentMapper;
import br.com.fiap.boundaryservice.repository.IPaymentRepository;
import br.com.fiap.boundaryservice.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService implements IPaymentService {
  private final IPaymentRepository repository;

  @Autowired
  PaymentMapper paymentMapper;

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
  public PaymentDTO createPayment(PaymentDTO paymentDTO) {
    Payment paymentEntity = paymentMapper.toEntity(paymentDTO);

    paymentEntity = this.repository.save(paymentEntity);
    return paymentMapper.toDTO(paymentEntity);
  }

}
