package com.kerrrusha.transportrental.repository;

import com.kerrrusha.transportrental.model.Transport;
import org.springframework.data.repository.CrudRepository;

public interface TransportRepository extends CrudRepository<Transport, Long> {

    Transport findByLicensePlate(String licensePlate);

}
