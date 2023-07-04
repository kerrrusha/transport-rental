package com.kerrrusha.transportrental.service.map;

import com.kerrrusha.transportrental.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CustomerMapServiceTest {

    private static final String FIRST_NAME = "John";
    private static final String DOCUMENT_ID = "123456789";
    private static final long ID = 1L;

    CustomerMapService service;

    @BeforeEach
    void setUp() {
        service = new CustomerMapService();
        service.save(Customer.builder().id(ID).firstName(FIRST_NAME).documentId(DOCUMENT_ID).build());
    }

    @Test
    void findById() {
        Customer customer = service.findById(ID);

        assertEquals(ID, customer.getId());
    }

    @Test
    void findAll() {
        Set<Customer> result = service.findAll();

        assertEquals(1, result.size());
    }

    @Test
    void saveWithId() {
        Long id = 2L;
        Customer customer2 = Customer.builder().id(id).build();

        Customer saved = service.save(customer2);
        assertEquals(id, saved.getId());
    }

    @Test
    void saveWithoutId() {
        Customer saved = service.save(new Customer());

        assertNotNull(saved);
        assertNotNull(saved.getId());
    }

    @Test
    @Rollback
    @Transactional
    void delete() {
        service.delete(service.findById(ID));

        assertEquals(0, service.findAll().size());
    }

    @Test
    @Rollback
    @Transactional
    void deleteById() {
        service.deleteById(ID);

        assertEquals(0, service.findAll().size());
    }

    @Test
    void findByDocumentId() {
        Customer result = service.findByDocumentId(DOCUMENT_ID);

        assertNotNull(result);
        assertEquals(ID, result.getId());
    }

    @Test
    void findByDocumentIdNotFound() {
        Customer result = service.findByDocumentId("159");

        assertNull(result);
    }
    
}