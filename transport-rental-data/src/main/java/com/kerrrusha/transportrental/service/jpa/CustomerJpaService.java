package com.kerrrusha.transportrental.service.jpa;

import com.kerrrusha.transportrental.model.Customer;
import com.kerrrusha.transportrental.repository.CustomerRepository;
import com.kerrrusha.transportrental.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpa")
@RequiredArgsConstructor
public class CustomerJpaService implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Customer> findAll() {
        Set<Customer> result = new HashSet<>();
        customerRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public Customer save(Customer object) {
        return customerRepository.save(object);
    }

    @Override
    public void delete(Customer object) {
        customerRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer findByDocumentId(String documentId) {
        return customerRepository.findByDocumentId(documentId).orElse(null);
    }

}
