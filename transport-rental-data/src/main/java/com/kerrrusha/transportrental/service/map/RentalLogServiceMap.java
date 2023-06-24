package com.kerrrusha.transportrental.service.map;

import com.kerrrusha.transportrental.model.Customer;
import com.kerrrusha.transportrental.model.RentalLog;
import com.kerrrusha.transportrental.model.Transport;
import com.kerrrusha.transportrental.service.CustomerService;
import com.kerrrusha.transportrental.service.RentalLogService;
import com.kerrrusha.transportrental.service.TransportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class RentalLogServiceMap extends AbstractMapService<RentalLog, Long> implements RentalLogService {

    private final CustomerService customerService;
    private final TransportService transportService;

    @Override
    public RentalLog save(RentalLog object) {
        object = super.save(object);

        if (nonNull(object.getCustomer())) {
            Customer customerWithId = customerService.save(object.getCustomer());
            object.setCustomer(customerWithId);
        }
        if (nonNull(object.getTransport())) {
            Transport transportWithId = transportService.save(object.getTransport());
            object.setTransport(transportWithId);
        }

        return object;
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
