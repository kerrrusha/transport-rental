package com.kerrrusha.transportrental.service.map;

import com.kerrrusha.transportrental.model.Transport;
import com.kerrrusha.transportrental.model.TransportType;
import com.kerrrusha.transportrental.service.TransportService;
import com.kerrrusha.transportrental.service.TransportTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class TransportServiceMap extends AbstractMapService<Transport, Long> implements TransportService {

    private final TransportTypeService transportTypeService;

    @Override
    public Transport save(Transport object) {
        object = super.save(object);

        if (nonNull(object.getTransportType())) {
            TransportType transportTypeWithId = transportTypeService.save(object.getTransportType());
            object.setTransportType(transportTypeWithId);
        }

        return object;
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
