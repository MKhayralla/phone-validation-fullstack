package com.jumia.phone.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.jumia.phone.entity.PageResponse;
import com.jumia.phone.entity.PhoneNumber;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PaginationServiceTest {
    @Autowired
    private PaginationService service ;
    @Test
    void testPaginateResults() {
        List<PhoneNumber> resultsSample = List.of(
            new PhoneNumber("name1", "phone1"),
            new PhoneNumber("name2", "phone2"),
            new PhoneNumber("name3", "phone3")
        ) ;
        // normal page
        PageResponse result1 = service.paginateResults(resultsSample, 1, 2) ;
        // Last page
        PageResponse result2 = service.paginateResults(resultsSample, 2, 2) ;
        // Out of bounds
        PageResponse result3 = service.paginateResults(resultsSample, 3, 2) ;
        // test number of pages result
        assertEquals(2, result1.getNumberOfPages());
        assertEquals(2, result2.getNumberOfPages());
        assertEquals(2, result3.getNumberOfPages());
        // test results
        assertEquals(2, result1.getPhoneNumbers().size());
        assertEquals(1, result2.getPhoneNumbers().size());
        assertEquals(0, result3.getPhoneNumbers().size());
    }
}
