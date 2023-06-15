package com.kerrrusha.transportrental.service;

import com.kerrrusha.transportrental.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer findBy(Long id);
    Customer findByDocumentId(String documentId);
    Customer save(Customer customer);
    List<Customer> findAll();

}
