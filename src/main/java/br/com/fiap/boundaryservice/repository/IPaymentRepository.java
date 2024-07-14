package br.com.fiap.boundaryservice.repository;

import br.com.fiap.boundaryservice.model.Payment;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface IPaymentRepository extends MongoRepository<Payment, String> {

}
