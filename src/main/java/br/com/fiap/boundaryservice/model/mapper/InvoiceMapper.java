package br.com.fiap.boundaryservice.model.mapper;

import br.com.fiap.boundaryservice.model.dto.InvoiceDTO;
import br.com.fiap.boundaryservice.model.entity.Invoice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {

  InvoiceDTO toDTO(Invoice invoice);
  Invoice toEntity(InvoiceDTO invoiceDTO);

}
