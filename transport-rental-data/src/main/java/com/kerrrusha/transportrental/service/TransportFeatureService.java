package com.kerrrusha.transportrental.service;

import com.kerrrusha.transportrental.model.TransportFeature;

public interface TransportFeatureService extends CrudService<TransportFeature, Long> {

    TransportFeature findByName(String name);

}
