package com.kerrrusha.transportrental.service;

import com.kerrrusha.transportrental.model.TransportType;

public interface TransportTypeService extends CrudService<TransportType, Long> {

    TransportType findByPerMinuteRentalPriceBetween(Long start, Long end);

}
