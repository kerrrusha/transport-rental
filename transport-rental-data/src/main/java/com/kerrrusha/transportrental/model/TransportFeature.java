package com.kerrrusha.transportrental.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class TransportFeature extends BaseEntity {

    private String name;

    @ManyToMany(mappedBy = "features")
    private Set<Transport> transports = new HashSet<>();

    public void addTransport(Transport transport) {
        transports.add(transport);
    }

    @Override
    public String toString() {
        return "TransportFeature{" +
                "name='" + name + '\'' +
                '}';
    }

}