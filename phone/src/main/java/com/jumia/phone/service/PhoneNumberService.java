package com.jumia.phone.service;


import java.util.List;

import com.jumia.phone.dao.PhoneNumberRepo;
import com.jumia.phone.entity.PageResponse;
import com.jumia.phone.entity.PhoneNumber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PhoneNumberService {
    @Autowired
    private PhoneNumberRepo phoneRepository ;
        @Autowired
        private ValidationService validate ;
        @Autowired
        private PaginationService paginate ;
        @Value("${paginating.chunk-size}")
        private Integer chunkSize ;
    public PageResponse getPhoneNumbers(
        Integer pageNumber,
        String countryCode,
        String stateCode,
        String phone,
        String ext,
        Boolean validateData
        ) {
        List<PhoneNumber> result = phoneRepository.findAll() ;
        List<PhoneNumber> filteredResult = validateData ?
        validate.validateAndFilter(
            result,
            countryCode,
            stateCode,
            phone,
            ext
            ) : 
        validate.Filter(
            result,
            countryCode,
            stateCode,
            phone,
            ext
            ) ;
        return paginate.paginateResults(filteredResult, pageNumber, chunkSize) ;
    }
}
