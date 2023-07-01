package com.kerrrusha.transportrental.model;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ExtendWith(SpringExtension.class)
//@RequiredArgsConstructor(onConstructor = @__(@Autowired)) //you can use it instead of regular constructor
public class CustomerValidationTest {

    private final TestEntityManager entityManager;
    private final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = validatorFactory.getValidator();

    public CustomerValidationTest(@Autowired TestEntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Test
    public void testBlankFirstName() {
        Customer customer = new Customer();
        customer.setFirstName("");
        customer.setLastName("Doe");
        customer.setPhone("123456789");
        customer.setDocumentId("ABCD1234");

        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);

        assertEquals(2, violations.size());
        ConstraintViolation<Customer> violation = violations.iterator().next();
        assertEquals("firstName", violation.getPropertyPath().toString());
    }

    @Test
    public void testShortFirstName() {
        Customer customer = new Customer();
        customer.setFirstName("A");
        customer.setLastName("Doe");
        customer.setPhone("123456789");
        customer.setDocumentId("ABCD1234");

        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);

        assertEquals(1, violations.size());
        ConstraintViolation<Customer> violation = violations.iterator().next();
        assertEquals("size must be between 2 and 32", violation.getMessage());
        assertEquals("firstName", violation.getPropertyPath().toString());
    }

    @Test
    public void testOkFirstName() {
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setPhone("123456789");
        customer.setDocumentId("ABCD1234");

        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);

        assertEquals(0, violations.size());
    }

}
