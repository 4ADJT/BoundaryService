package br.com.fiap.boundaryservice.repository;

import br.com.fiap.boundaryservice.model.entity.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInvoiceRepository extends MongoRepository<Invoice, String> {
}
