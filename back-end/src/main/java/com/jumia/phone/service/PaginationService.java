package com.jumia.phone.service;

import java.util.List;

import com.jumia.phone.entity.PageResponse;
import com.jumia.phone.entity.PhoneNumber;

import org.springframework.stereotype.Service;

@Service
public class PaginationService {
    /**
     * paginate a list of results and return the current page
     * @param results:List<PhoneNumber> phone numbers to paginate
     * @param pageNumber:Integer current page
     * @param chunkSize:Integer size of page
     * @return requiredPage:PageResponse
     */
    public PageResponse paginateResults (
        List<PhoneNumber> results,
        Integer pageNumber,
        Integer chunkSize
        ) {
            // instantiate a new page response to fill 
            PageResponse response = new PageResponse() ;
            // set number of pages based on phones input
            response.setNumberOfPages((int)(Math.ceil((double)results.size() / chunkSize)));
            // first element in the page
            Integer start = (pageNumber - 1) * chunkSize ;
            // size of all data
            Integer size = results.size() ;
            // supposed last element
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
