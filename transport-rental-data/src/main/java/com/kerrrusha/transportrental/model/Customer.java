package com.kerrrusha.transportrental.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Customer extends BaseEntity {

    @NotBlank
    @Size(min = 2, max = 32)
    private String firstName;
    private String lastName;
    private String phone;
    private String documentId;

}
