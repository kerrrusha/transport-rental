package com.kerrrusha.transportrental.service.map;

import com.kerrrusha.transportrental.model.Customer;
import com.kerrrusha.transportrental.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CustomerMapService extends AbstractMapService<Customer, Long> implements CustomerService {

    @Override
    public Customer findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Customer> findAll() {
        return super.findAll();
    }

    @Override
    public Customer save(Customer object) {
        return super.save(object);
    }

    @Override
    public void delete(Customer object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Customer findByDocumentId(String documentId) {
        return super.findAll().stream()
                .filter(elem -> elem.getDocumentId().equals(documentId))
                .findFirst().orElse(null);
    }

}
