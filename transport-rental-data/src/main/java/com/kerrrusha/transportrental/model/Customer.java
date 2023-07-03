package com.kerrrusha.transportrental.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"document_id"})})
public class Customer extends BaseEntity {

    @NotBlank
    @Size(min = 2, max = 32)
    private String firstName;
    private String lastName;
    private String phone;

    @Column(name = "document_id")
    private String documentId;

}
