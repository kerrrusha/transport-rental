package com.kerrrusha.transportrental.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Customer extends BaseEntity {

    private String firstName;
    private String lastName;
    private String phone;
    private String documentId;

}
