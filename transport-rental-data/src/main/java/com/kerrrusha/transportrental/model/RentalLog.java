package com.kerrrusha.transportrental.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import static com.kerrrusha.transportrental.util.FormatUtil.formatDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class RentalLog extends BaseEntity {

    public RentalLog(Long id) {
        this.id = id;
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
