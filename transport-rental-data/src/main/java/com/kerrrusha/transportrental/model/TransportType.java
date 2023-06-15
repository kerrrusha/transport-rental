package com.kerrrusha.transportrental.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class TransportType extends BaseEntity {

    private String title;
    private Long marketPrice;
    private Long perMinuteRentalPrice;
    private Integer personCapacity;
    private Integer maxSpeedAllowed;

}
