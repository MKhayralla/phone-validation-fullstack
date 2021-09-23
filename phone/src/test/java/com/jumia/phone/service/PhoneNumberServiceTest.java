package com.jumia.phone.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.jumia.phone.entity.PageResponse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PhoneNumberServiceTest {
    @Autowired
    private PhoneNumberService service ;
    @Test
    void testGetPhoneNumbers() {
        // 1 Number
        PageResponse resultResponse1 = service.getPhoneNumbers(
            1,
            "212",
            "6",
            "98054",
            "",
            true
            ) ;
        // 7 Numbers
        PageResponse resultResponse2 = service.getPhoneNumbers(
            1,
            "212",
            "",
            "",
            "",
            false
            ) ;
        // All Numbers
        PageResponse resultResponse3 = service.getPhoneNumbers(
            4,
            "[0-9]*",
            "",
            "",
            "",
            true
            ) ;
        // Test number of pages in the response
        assertEquals(1, resultResponse1.getNumberOfPages());
        assertEquals(1, resultResponse2.getNumberOfPages());
        assertEquals(3, resultResponse3.getNumberOfPages());
        // Test size of response list in the response
        assertEquals(1, resultResponse1.getPhoneNumbers().size());
        assertEquals(7, resultResponse2.getPhoneNumbers().size());
        assertEquals(0, resultResponse3.getPhoneNumbers().size());
    }
}
