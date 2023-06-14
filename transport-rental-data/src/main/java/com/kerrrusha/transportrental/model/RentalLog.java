package com.kerrrusha.transportrental.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RentalLog {

    private Customer customer;
    private Transport transport;
    private LocalDateTime rentStart;
    private LocalDateTime rentEnd;

}
