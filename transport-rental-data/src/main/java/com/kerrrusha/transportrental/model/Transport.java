package com.kerrrusha.transportrental.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Transport extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "transport_type_id")
    private TransportType transportType;

    private String licensePlate;

}
