package com.kerrrusha.transportrental.service;

import com.kerrrusha.transportrental.model.Customer;
import com.kerrrusha.transportrental.model.RentalLog;

import java.util.List;

public interface RentalLogService {

    RentalLog findBy(Long id);
    List<RentalLog> findByCustomer(Customer customer);
    RentalLog save(RentalLog customer);
    List<RentalLog> findAll();

}
