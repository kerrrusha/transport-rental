package com.kerrrusha.transportrental.repository;

import com.kerrrusha.transportrental.model.Customer;
import com.kerrrusha.transportrental.model.RentalLog;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface RentalLogRepository extends CrudRepository<RentalLog, Long> {

    Set<RentalLog> findAllByCustomer(Customer customer);

}
