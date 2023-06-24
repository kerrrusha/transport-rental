package com.kerrrusha.transportrental.bootstrap;

import com.kerrrusha.transportrental.model.Customer;
import com.kerrrusha.transportrental.model.RentalLog;
import com.kerrrusha.transportrental.model.Transport;
import com.kerrrusha.transportrental.model.TransportType;
import com.kerrrusha.transportrental.service.CustomerService;
import com.kerrrusha.transportrental.service.RentalLogService;
import com.kerrrusha.transportrental.service.TransportService;
import com.kerrrusha.transportrental.service.TransportTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final CustomerService customerService;
    private final RentalLogService rentalLogService;
    private final TransportService transportService;
    private final TransportTypeService transportTypeService;

    @Override
    public void run(String... args) {
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Smith");
        customer.setPhone("+380123456789");
        customer.setDocumentId("00123568");

        Customer customer1 = new Customer();
        customer.setFirstName("Sara");
        customer.setLastName("Connor");
        customer.setPhone("+380123456790");
        customer.setDocumentId("00534632");

        TransportType transportType = new TransportType();
        transportType.setTitle("Bicycle");
        transportType.setPerMinuteRentalPrice(10L);
        transportType.setMarketPrice(30000L);
        transportType.setMaxSpeed(50);
        transportType.setPersonCapacity(1);

        Transport transport = new Transport();
        transport.setTransportType(transportType);
        transport.setLicensePlate("AA0001EC");

        RentalLog rentalLog1 = new RentalLog();
        rentalLog1.setCustomer(customer);
        rentalLog1.setTransport(transport);
        rentalLog1.setRentStart(LocalDateTime.now());
        rentalLog1.setRentEnd(LocalDateTime.now().plusHours(1));
        rentalLogService.save(rentalLog1);

        RentalLog rentalLog2 = new RentalLog();
        rentalLog2.setCustomer(customer1);
        rentalLog2.setTransport(transport);
        rentalLog2.setRentStart(LocalDateTime.now());
        rentalLog2.setRentEnd(LocalDateTime.now().plusHours(1));
        rentalLogService.save(rentalLog2);

        log.info("Loaded {} customers", customerService.findAll().size());
        log.info("Loaded {} transport types", transportTypeService.findAll().size());
        log.info("Loaded {} transports", transportService.findAll().size());
        log.info("Loaded {} rental logs", rentalLogService.findAll().size());
    }

}
