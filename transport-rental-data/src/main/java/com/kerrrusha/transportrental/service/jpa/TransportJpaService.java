package com.kerrrusha.transportrental.service.jpa;

import com.kerrrusha.transportrental.model.Transport;
import com.kerrrusha.transportrental.repository.TransportRepository;
import com.kerrrusha.transportrental.service.TransportService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpa")
@RequiredArgsConstructor
public class TransportJpaService implements TransportService {

    private final TransportRepository transportRepository;

    @Override
    public Transport findById(Long id) {
        return transportRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Transport> findAll() {
        Set<Transport> result = new HashSet<>();
        transportRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public Transport save(Transport object) {
        return transportRepository.save(object);
    }

    @Override
    public void delete(Transport object) {
        transportRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        transportRepository.deleteById(id);
    }

    @Override
    public Transport findByLicensePlate(String licensePlate) {
        return transportRepository.findByLicensePlate(licensePlate);
    }

}
