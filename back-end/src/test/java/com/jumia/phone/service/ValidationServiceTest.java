package com.jumia.phone.service;

import com.jumia.phone.entity.PhoneNumber;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
@SpringBootTest
public class ValidationServiceTest {
    @Autowired
    private ValidationService service ;
    @Test
    void testValidationService() {
        PhoneNumber rightPhoneNumber1 = new PhoneNumber("Mahmoud Morocco", "(212) 512345678") ;
        PhoneNumber rightPhoneNumber2 = new PhoneNumber("Mahmoud Uganda", "(256) 123456789") ;
        PhoneNumber wrongPhoneNumber1 = new PhoneNumber("Mahmoud Egypt", "(20) 1066114089") ;
        PhoneNumber wrongPhoneNumber2 = new PhoneNumber("Mahmoud Nowhere", "(90015) xnor254") ;
        List<PhoneNumber> allPhones = List.of(
            rightPhoneNumber1,
            rightPhoneNumber2,
            wrongPhoneNumber1,
            wrongPhoneNumber2
        ) ;
        // Validation Test
        List<PhoneNumber> validationResult = service.validate(allPhones) ;
        assertTrue(validationResult.contains(rightPhoneNumber1));
        assertTrue(validationResult.contains(rightPhoneNumber2));
        assertFalse(validationResult.contains(wrongPhoneNumber1));
        assertFalse(validationResult.contains(wrongPhoneNumber2));
        // Filtering Test
        List<PhoneNumber> FilteringResult = service.Filter(
            allPhones,
            "20",
            "10",
            "6611",
            "4089"
            ) ;
        assertFalse(FilteringResult.contains(rightPhoneNumber1));
        assertFalse(FilteringResult.contains(rightPhoneNumber2));
        assertTrue(FilteringResult.contains(wrongPhoneNumber1));
        assertFalse(FilteringResult.contains(wrongPhoneNumber2));
        // Validation and Filtering Test
        List<PhoneNumber> validationAndFilteringResult = service.validateAndFilter(
            allPhones,
            "212",
            "5",
            "1234",
            ""
            ) ;
        assertTrue(validationAndFilteringResult.contains(rightPhoneNumber1));
        assertFalse(validationAndFilteringResult.contains(rightPhoneNumber2));
        assertFalse(validationAndFilteringResult.contains(wrongPhoneNumber1));
        assertFalse(validationAndFilteringResult.contains(wrongPhoneNumber2));
    }

}
