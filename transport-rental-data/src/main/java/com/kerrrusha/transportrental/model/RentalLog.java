package com.kerrrusha.transportrental.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class RentalLog extends BaseEntity {

    private static final String DATETIME_PATTERN = "HH:mm dd.MM.yyyy";

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "transport_id")
    private Transport transport;

    @DateTimeFormat(pattern = DATETIME_PATTERN)
    private LocalDateTime rentStart;

    @DateTimeFormat(pattern = DATETIME_PATTERN)
    private LocalDateTime rentEnd;

}
