package br.com.fiap.boundaryservice.model.mapper;

import br.com.fiap.boundaryservice.model.dto.PaymentDTO;
import br.com.fiap.boundaryservice.model.entity.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

  PaymentDTO toDTO(Payment payment);
  Payment toEntity(PaymentDTO paymentDTO);

}
