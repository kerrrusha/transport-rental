package com.kerrrusha.transportrental.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransportType {

    private String title;
    private Long marketPrice;
    private Long perMinuteRentalPrice;
    private Integer personCapacity;
    private Integer maxSpeedAllowed;

}
