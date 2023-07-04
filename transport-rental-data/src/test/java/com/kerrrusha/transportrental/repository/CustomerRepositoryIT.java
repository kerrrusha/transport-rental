package com.kerrrusha.transportrental.repository;

import com.kerrrusha.transportrental.model.Customer;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class CustomerRepositoryIT {

    final CustomerRepository customerRepository;

    Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer();
        customer.setFirstName("John II");
        customer.setDocumentId("223400343");
    }

    @Test
    @Rollback
    @Transactional
    void findByDocumentId() {
        customerRepository.save(customer);
        Optional<Customer> result = customerRepository.findByDocumentId("223400343");
        assertEquals("223400343", result.get().getDocumentId());
    }

    @Test
    @Rollback
    @Transactional
    void crudTest() {
        assertTrue(customerRepository.findByDocumentId("223400343").isEmpty());

        //create
        Customer customerSaved = customerRepository.save(customer);

        //read
        assertTrue(customerRepository.findByDocumentId("223400343").isPresent());

        customerSaved.setLastName("Doe");
        customerRepository.save(customerSaved);

        //update
        assertEquals("Doe", customerRepository.findByDocumentId("223400343").get().getLastName());

        customerRepository.deleteById(customerSaved.getId());

        //delete
        assertTrue(customerRepository.findByDocumentId("223400343").isEmpty());
    }

}
