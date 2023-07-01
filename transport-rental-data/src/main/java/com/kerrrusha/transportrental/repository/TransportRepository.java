package com.kerrrusha.transportrental.repository;

import com.kerrrusha.transportrental.model.RentalLog;
import org.springframework.data.repository.CrudRepository;

public interface TransportRepository extends CrudRepository<RentalLog, Long> {
}
