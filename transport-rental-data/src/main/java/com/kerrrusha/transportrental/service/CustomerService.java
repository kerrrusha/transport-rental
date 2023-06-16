package com.kerrrusha.transportrental.service;

import com.kerrrusha.transportrental.model.Customer;

public interface CustomerService extends CrudService<Customer, Long> {

    Customer findByDocumentId(String documentId);

}
