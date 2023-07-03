package com.kerrrusha.transportrental.repository;

import com.kerrrusha.transportrental.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Optional<Customer> findByDocumentId(String documentId);

}
