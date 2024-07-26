package br.com.fiap.boundaryservice.service.implementation;

import br.com.fiap.boundaryservice.model.dto.PaymentDTO;
import br.com.fiap.boundaryservice.model.entity.Payment;
import br.com.fiap.boundaryservice.model.mapper.PaymentMapper;
import br.com.fiap.boundaryservice.model.utils.PaymentStatusENUM;
import br.com.fiap.boundaryservice.model.utils.PaymentTypeENUM;
import br.com.fiap.boundaryservice.repository.IPaymentRepository;
import br.com.fiap.boundaryservice.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService implements IPaymentService {
  private final IPaymentRepository repository;
  private final PaymentMapper mapper;

  @Autowired
  PaymentMapper paymentMapper;

  @Autowired
  public PaymentService(IPaymentRepository repository, PaymentMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  @Override
  public Page<PaymentDTO> getPayments(Pageable pageable) {

    Page<Payment> payments = repository.findAll(pageable);

    return payments.map(mapper::toDTO);
  }

  @Override
  public PaymentDTO getPayment(String id) {
    return paymentMapper.toDTO(this.repository
        .findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Payment not found")));
  }

  @Override
  public PaymentDTO createPayment(PaymentDTO paymentDTO) {
    Payment paymentEntity = paymentMapper.toEntity(paymentDTO);

    if (paymentEntity.getType() == PaymentTypeENUM.PIX && paymentEntity.getPix() == null) {
      throw new IllegalArgumentException("Pix required");
    }

    if ((paymentEntity.getType() == PaymentTypeENUM.CREDIT || paymentEntity.getType() == PaymentTypeENUM.DEBIT) && paymentEntity.getCard() == null) {
      throw new IllegalArgumentException("Card required");
    }

    paymentEntity.setPaid(true);
    paymentEntity.setStatus(PaymentStatusENUM.PAID);

    paymentEntity = this.repository.save(paymentEntity);
    return paymentMapper.toDTO(paymentEntity);
  }

}
