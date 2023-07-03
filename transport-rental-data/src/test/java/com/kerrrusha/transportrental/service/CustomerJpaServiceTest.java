package com.kerrrusha.transportrental.service;

import com.kerrrusha.transportrental.model.Customer;
import com.kerrrusha.transportrental.repository.CustomerRepository;
import com.kerrrusha.transportrental.service.jpa.CustomerJpaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerJpaServiceTest {

    CustomerJpaService customerService;

    @Mock
    CustomerRepository customerRepository;

    @BeforeEach
    public void setUp() {
        customerService = new CustomerJpaService(customerRepository);
    }

    @Test
    public void findAll() {
        Set<Customer> initialData = Set.of(new Customer());
        when(customerRepository.findAll()).thenReturn(initialData);

        Set<Customer> result = customerService.findAll();

        assertEquals(result.size(), 1);
        verify(customerRepository, times(1)).findAll();
    }

}
