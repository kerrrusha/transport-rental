package com.kerrrusha.transportrental.repository;

import com.kerrrusha.transportrental.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
