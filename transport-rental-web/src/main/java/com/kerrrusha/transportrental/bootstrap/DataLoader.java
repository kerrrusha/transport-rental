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
        //customerService.save(customer);

        Customer customer1 = new Customer();
        customer.setFirstName("Sara");
        customer.setLastName("Connor");
        customer.setPhone("+380123456790");
        customer.setDocumentId("00534632");
        //customerService.save(customer1);

        TransportType transportType = new TransportType();
        transportType.setTitle("Bicycle");
        transportType.setPerMinuteRentalPrice(10L);
        transportType.setMarketPrice(30000L);
        transportType.setMaxSpeed(50);
        transportType.setPersonCapacity(1);
        //transportTypeService.save(transportType);

        Transport transport = new Transport();
        transport.setTransportType(transportType);
        transport.setLicensePlate("AA0001EC");
        //transportService.save(transport);

        RentalLog rentalLog = new RentalLog();
        rentalLog.setCustomer(customer);
        rentalLog.setTransport(transport);
        rentalLog.setRentStart(LocalDateTime.now());
        rentalLog.setRentEnd(LocalDateTime.now().plusHours(1));
        rentalLogService.save(rentalLog);

        log.info("Loaded {} customers", customerService.findAll().size());
        log.info("Loaded {} transport types", transportTypeService.findAll().size());
        log.info("Loaded {} transports", transportService.findAll().size());
        log.info("Loaded {} rental logs", rentalLogService.findAll().size());
    }

}
