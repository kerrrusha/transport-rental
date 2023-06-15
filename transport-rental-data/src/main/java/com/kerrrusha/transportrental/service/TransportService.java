package com.kerrrusha.transportrental.service;

import com.kerrrusha.transportrental.model.Transport;

import java.util.List;

public interface TransportService {

    Transport findBy(Long id);
    Transport findByLicensePlate(String licensePlate);
    Transport save(Transport customer);
    List<Transport> findAll();

}
