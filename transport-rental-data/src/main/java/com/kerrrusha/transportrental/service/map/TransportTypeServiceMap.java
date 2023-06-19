package com.kerrrusha.transportrental.service.map;

import com.kerrrusha.transportrental.model.TransportType;
import com.kerrrusha.transportrental.service.TransportTypeService;
import org.springframework.stereotype.Service;

@Service
public class TransportTypeServiceMap extends AbstractMapService<TransportType, Long> implements TransportTypeService {

    @Override
    public TransportType save(TransportType object) {
        return map.put(object.getId(), object);
    }

    @Override
    public void delete(TransportType object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public TransportType findByPerMinuteRentalPriceBetween(Long start, Long end) {
        return super.findAll().stream()
                .filter(elem -> start <= elem.getPerMinuteRentalPrice() && elem.getPerMinuteRentalPrice() < end)
                .findAny().orElse(null);
    }

}
