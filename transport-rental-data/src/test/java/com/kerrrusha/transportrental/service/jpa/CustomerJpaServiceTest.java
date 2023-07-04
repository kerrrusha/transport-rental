package com.kerrrusha.transportrental.service.jpa;

import com.kerrrusha.transportrental.model.Customer;
import com.kerrrusha.transportrental.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerJpaServiceTest {

    private static final String FIRST_NAME = "John";
    private static final String DOCUMENT_ID = "123456789";
    private static final Long ID = 1L;

    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    CustomerJpaService service;

    Customer givenCustomer;

    @BeforeEach
    void setUp() {
        givenCustomer = Customer.builder().id(ID).firstName(FIRST_NAME).documentId(DOCUMENT_ID).build();
    }

    @Test
    void findById() {
        when(customerRepository.findById(any())).thenReturn(Optional.ofNullable(givenCustomer));
        Customer result = service.findById(ID);
        assertEquals(ID, result.getId());
        verify(customerRepository).findById(any());
    }

    @Test
    void findByIdNotFound() {
        when(customerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Customer customer = service.findById(1L);

        assertNull(customer);
    }

    @Test
    void findAll() {
        Set<Customer> givenSet = new HashSet<>();
        givenSet.add(Customer.builder().id(1L).firstName("abc").documentId("123").build());
        givenSet.add(Customer.builder().id(2L).firstName("def").documentId("456").build());

        when(customerRepository.findAll()).thenReturn(givenSet);

        Set<Customer> result = service.findAll();

        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void save() {
        Customer customerToSave = Customer.builder().id(1L).build();

        when(customerRepository.save(any())).thenReturn(givenCustomer);

        Customer savedCustomer = service.save(customerToSave);

        assertNotNull(savedCustomer);
        verify(customerRepository).save(any());
    }

    @Test
    void delete() {
        service.delete(givenCustomer);

        verify(customerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);

        verify(customerRepository).deleteById(anyLong());
    }

    @Test
    void findByDocumentId() {
        when(customerRepository.findByDocumentId(any())).thenReturn(Optional.ofNullable(givenCustomer));

        Customer result = service.findByDocumentId(DOCUMENT_ID);

        assertEquals(DOCUMENT_ID, result.getDocumentId());
        verify(customerRepository).findByDocumentId(any());
    }

}
