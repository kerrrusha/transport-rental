package com.kerrrusha.transportrental.service.map;

import com.kerrrusha.transportrental.model.Customer;
import com.kerrrusha.transportrental.model.RentalLog;
import com.kerrrusha.transportrental.service.RentalLogService;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class RentalLogServiceMap extends AbstractMapService<RentalLog, Long> implements RentalLogService {

    @Override
    public RentalLog save(RentalLog object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(RentalLog object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public List<RentalLog> findByCustomer(Customer customer) {
        return super.findAll().stream()
                .filter(elem -> elem.getCustomer().equals(customer))
                .collect(toList());
    }

}
