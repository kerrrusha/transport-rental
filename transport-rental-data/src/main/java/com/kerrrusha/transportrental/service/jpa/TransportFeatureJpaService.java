package com.kerrrusha.transportrental.service.jpa;

import com.kerrrusha.transportrental.model.TransportFeature;
import com.kerrrusha.transportrental.repository.TransportFeatureRepository;
import com.kerrrusha.transportrental.service.TransportFeatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpa")
@RequiredArgsConstructor
public class TransportFeatureJpaService implements TransportFeatureService {

    private final TransportFeatureRepository transportFeatureRepository;

    @Override
    public TransportFeature findById(Long id) {
        return transportFeatureRepository.findById(id).orElse(null);
    }

    @Override
    public Set<TransportFeature> findAll() {
        Set<TransportFeature> result = new HashSet<>();
        transportFeatureRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public TransportFeature save(TransportFeature object) {
        return transportFeatureRepository.save(object);
    }

    @Override
    public void delete(TransportFeature object) {
        transportFeatureRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        transportFeatureRepository.deleteById(id);
    }

    @Override
    public TransportFeature findByName(String name) {
        return transportFeatureRepository.findByName(name);
    }

}
