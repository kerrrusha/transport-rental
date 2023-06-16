package com.kerrrusha.transportrental.service;

import com.kerrrusha.transportrental.model.Transport;

public interface TransportService extends CrudService<Transport, Long> {

    Transport findByLicensePlate(String licensePlate);

}
