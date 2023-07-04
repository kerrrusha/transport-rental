package com.kerrrusha.transportrental.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

import static com.kerrrusha.transportrental.util.FormatUtil.formatPrice;
import static com.kerrrusha.transportrental.util.FormatUtil.formatSpeed;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
public class Transport extends BaseEntity {

    @NotBlank
    private String title;
    private Long marketPrice;
    private Long perMinuteRentalPrice;
    private Integer personCapacity;
    private Integer maxSpeed;
    private String licensePlate;

    @ManyToOne
    @JoinColumn(name = "transport_type_id")
    private TransportType transportType;

    @ManyToMany
    @JoinTable(name = "transport_to_feature",
            joinColumns = @JoinColumn(name = "transport_id"),
            inverseJoinColumns = @JoinColumn(name = "transport_feature_id"))
    private Set<TransportFeature> features = new HashSet<>();

    public void addFeature(TransportFeature feature) {
        features.add(feature);
        feature.addTransport(this);
    }

    public String getMarketPriceFormatted() {
        return formatPrice(marketPrice);
    }

    public String getPerMinuteRentalPriceFormatted() {
        return formatPrice(perMinuteRentalPrice);
    }

    public String getMaxSpeedFormatted() {
        return formatSpeed(perMinuteRentalPrice);
    }

}
