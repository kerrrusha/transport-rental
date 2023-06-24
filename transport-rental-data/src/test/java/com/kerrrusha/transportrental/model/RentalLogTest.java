package com.kerrrusha.transportrental.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class RentalLogTest {

    private static RentalLog exampleRentalLog;

    @BeforeAll
    static void setUp() {
        exampleRentalLog = new RentalLog();

        exampleRentalLog.setCustomer(new Customer());
        exampleRentalLog.setTransport(new Transport());
        exampleRentalLog.setRentStart(LocalDateTime.now());
        exampleRentalLog.setRentEnd(LocalDateTime.now().plusHours(1));
    }

    @Test
    void getRentStart() {
        System.out.println(exampleRentalLog.getRentStart());
    }

    @Test
    void getRentEnd() {
        System.out.println(exampleRentalLog.getRentEnd());
    }

}
