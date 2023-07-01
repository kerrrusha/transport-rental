package com.kerrrusha.transportrental.repository;

import com.kerrrusha.transportrental.model.TransportFeature;
import org.springframework.data.repository.CrudRepository;

public interface TransportFeatureRepository extends CrudRepository<TransportFeature, Long> {

    TransportFeature findByName(String name);

}
