package br.com.fiap.boundaryservice.service;

import br.com.fiap.boundaryservice.model.dto.InvoiceDTO;

public interface IInvoiceService {

  public InvoiceDTO createInvoice(InvoiceDTO invoiceDTO);

}
