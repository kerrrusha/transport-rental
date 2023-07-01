package com.kerrrusha.transportrental.bootstrap;

import com.kerrrusha.transportrental.model.*;
import com.kerrrusha.transportrental.service.*;
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
    private final TransportFeatureService transportFeatureService;

    @Override
    public void run(String... args) {
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Smith");
        customer.setPhone("+380123456789");
        customer.setDocumentId("00123568");
        customerService.save(customer);

        Customer customer1 = new Customer();
        customer1.setFirstName("Sara");
        customer1.setLastName("Connor");
        customer1.setPhone("+380123456790");
        customer1.setDocumentId("00534632");
        customerService.save(customer1);

        TransportType transportType = new TransportType();
        transportType.setName("Bicycle");
        transportTypeService.save(transportType);

        TransportFeature feature = new TransportFeature();
        feature.setName("eco");
        transportFeatureService.save(feature);

        Transport transport = new Transport();
        transport.setTitle("Trek Emonda SL 7 Disc");
        transport.setPerMinuteRentalPrice(10L);
        transport.setMarketPrice(337000L);
        transport.setMaxSpeed(50);
        transport.setPersonCapacity(1);
        transport.setTransportType(transportType);
        transport.addFeature(feature);
        transport.setLicensePlate("AA0001EC");
        transportService.save(transport);

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
        log.info("Loaded {} transport features", transportFeatureService.findAll().size());
        log.info("Loaded {} transports", transportService.findAll().size());
        log.info("Loaded {} rental logs", rentalLogService.findAll().size());
    }

}
