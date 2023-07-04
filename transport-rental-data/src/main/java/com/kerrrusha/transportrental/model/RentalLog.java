package com.kerrrusha.transportrental.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDateTime;

import static com.kerrrusha.transportrental.util.FormatUtil.formatDateTime;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
public class RentalLog extends BaseEntity {

    @Builder
    public RentalLog(Long id, Customer customer, Transport transport,
                     LocalDateTime rentStart, LocalDateTime rentEnd) {
        setId(id);
        this.customer = customer;
        this.transport = transport;
        this.rentStart = rentStart;
        this.rentEnd = rentEnd;
    }

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "transport_id")
    private Transport transport;

    private LocalDateTime rentStart;
    private LocalDateTime rentEnd;

    public String getRentStartFormatted() {
        return formatDateTime(getRentStart());
    }

    public String getRentEndFormatted() {
        return formatDateTime(getRentEnd());
    }

}
