package com.kerrrusha.transportrental.service.map;

import com.kerrrusha.transportrental.model.Transport;
import com.kerrrusha.transportrental.service.TransportService;
import org.springframework.stereotype.Service;

@Service
public class TransportServiceMap extends AbstractMapService<Transport, Long> implements TransportService {

    @Override
    public Transport save(Transport object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Transport object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Transport findByLicensePlate(String licensePlate) {
        return super.findAll().stream()
                .filter(elem -> elem.getLicensePlate().equals(licensePlate))
                .findAny().orElse(null);
    }

}
