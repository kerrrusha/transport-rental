package com.kerrrusha.transportrental.service.jpa;

import com.kerrrusha.transportrental.model.TransportType;
import com.kerrrusha.transportrental.repository.TransportTypeRepository;
import com.kerrrusha.transportrental.service.TransportTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpa")
@RequiredArgsConstructor
public class TransportTypeJpaService implements TransportTypeService {

    private final TransportTypeRepository transportTypeRepository;

    @Override
    public TransportType findById(Long id) {
        return transportTypeRepository.findById(id).orElse(null);
    }

    @Override
    public Set<TransportType> findAll() {
        Set<TransportType> result = new HashSet<>();
        transportTypeRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public TransportType save(TransportType object) {
        return transportTypeRepository.save(object);
    }

    @Override
    public void delete(TransportType object) {
        transportTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        transportTypeRepository.deleteById(id);
    }

}
