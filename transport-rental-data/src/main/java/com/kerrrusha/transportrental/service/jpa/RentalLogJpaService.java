package com.kerrrusha.transportrental.service.jpa;

import com.kerrrusha.transportrental.model.Customer;
import com.kerrrusha.transportrental.model.RentalLog;
import com.kerrrusha.transportrental.repository.RentalLogRepository;
import com.kerrrusha.transportrental.service.RentalLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpa")
@RequiredArgsConstructor
public class RentalLogJpaService implements RentalLogService {

    private final RentalLogRepository rentalLogRepository;

    @Override
    public RentalLog findById(Long id) {
        return rentalLogRepository.findById(id).orElse(null);
    }

    @Override
    public Set<RentalLog> findAll() {
        Set<RentalLog> result = new HashSet<>();
        rentalLogRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public RentalLog save(RentalLog object) {
        return rentalLogRepository.save(object);
    }

    @Override
    public void delete(RentalLog object) {
        rentalLogRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        rentalLogRepository.deleteById(id);
    }

    @Override
    public Set<RentalLog> findAllByCustomer(Customer customer) {
        return rentalLogRepository.findAllByCustomer(customer);
    }

}
