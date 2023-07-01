package com.kerrrusha.transportrental.service.map;

import com.kerrrusha.transportrental.model.TransportFeature;
import com.kerrrusha.transportrental.service.TransportFeatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Profile({"default", "map"})
public class TransportFeatureServiceMap extends AbstractMapService<TransportFeature, Long> implements TransportFeatureService {

    @Override
    public TransportFeature save(TransportFeature object) {
        return super.save(object);
    }

    @Override
    public void delete(TransportFeature object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public TransportFeature findByName(String name) {
        return super.findAll().stream()
                .filter(elem -> elem.getName().equals(name))
                .findFirst().orElse(null);
    }

}
