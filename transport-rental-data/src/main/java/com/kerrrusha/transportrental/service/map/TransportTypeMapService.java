package com.kerrrusha.transportrental.service.map;

import com.kerrrusha.transportrental.model.TransportType;
import com.kerrrusha.transportrental.service.TransportTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class TransportTypeMapService extends AbstractMapService<TransportType, Long> implements TransportTypeService {

    @Override
    public TransportType save(TransportType object) {
        return super.save(object);
    }

    @Override
    public void delete(TransportType object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

}
