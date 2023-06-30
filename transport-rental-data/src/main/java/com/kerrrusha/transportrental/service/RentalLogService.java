package com.kerrrusha.transportrental.service;

import com.kerrrusha.transportrental.model.Customer;
import com.kerrrusha.transportrental.model.RentalLog;

import java.util.Set;

public interface RentalLogService extends CrudService<RentalLog, Long> {

    Set<RentalLog> findByCustomer(Customer customer);

}
