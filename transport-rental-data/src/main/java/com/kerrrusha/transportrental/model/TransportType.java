package com.kerrrusha.transportrental.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class TransportType extends BaseEntity {

    @NotBlank
    private String name;

}
