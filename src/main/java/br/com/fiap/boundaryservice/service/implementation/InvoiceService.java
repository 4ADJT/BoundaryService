package br.com.fiap.boundaryservice.service.implementation;

import br.com.fiap.boundaryservice.model.dto.InvoiceDTO;
import br.com.fiap.boundaryservice.model.entity.Invoice;
import br.com.fiap.boundaryservice.model.mapper.InvoiceMapper;
import br.com.fiap.boundaryservice.repository.IInvoiceRepository;
import br.com.fiap.boundaryservice.service.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService implements IInvoiceService {
  private final IInvoiceRepository repository;
  private final InvoiceMapper mapper;

  @Autowired
  InvoiceService(IInvoiceRepository repository, InvoiceMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  /**
   * @param invoiceDTO
   * @return InvoiceDTO
   */
  @Override
  public InvoiceDTO createInvoice(InvoiceDTO invoiceDTO) {
    Invoice invoice = mapper.toEntity(invoiceDTO);

    invoice = repository.save(invoice);

    return mapper.toDTO(invoice);
  }
}
