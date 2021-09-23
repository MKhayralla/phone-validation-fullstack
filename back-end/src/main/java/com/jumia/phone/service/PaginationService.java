package com.jumia.phone.service;

import java.util.List;

import com.jumia.phone.entity.PageResponse;
import com.jumia.phone.entity.PhoneNumber;

import org.springframework.stereotype.Service;

@Service
public class PaginationService {
    public PageResponse paginateResults (
        List<PhoneNumber> results,
        Integer pageNumber,
        Integer chunkSize
        ) {
            PageResponse response = new PageResponse() ;
            response.setNumberOfPages((int)(Math.ceil((double)results.size() / chunkSize)));
            Integer start = (pageNumber - 1) * chunkSize ;
            Integer size = results.size() ;
            Integer end = start + chunkSize ;
            if (size <= start ) {
                // page number out of bounds
                response.setPhoneNumbers(List.of());
            }
            else if (size < pageNumber * chunkSize ) {
                // Last Page
                response.setPhoneNumbers(results.subList(start, size));
            }
            else {
                response.setPhoneNumbers(results.subList(start, end));
            }
            return response ;
    }
}
