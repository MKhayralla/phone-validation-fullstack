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
    private PhoneNumberRepo phoneRepository ; // jpa repository
    @Autowired
    private ValidationService validate ; // validation service
    @Autowired
    private PaginationService paginate ; // pagination service
    @Value("${paginating.chunk-size}")
    private Integer chunkSize ; // application.properties

    /**
     * 
     * @param pageNumber:Integer current page
     * @param countryCode:String filtering country code
     * @param stateCode:String filtering state code
     * @param phone:String filtering phone
     * @param ext:String filtering phone extention
     * @param validateData:Boolean whether to validate the data or not
     * @return paginatedNumbers:PageResponse results ready to be sent back as a response
     */
    public PageResponse getPhoneNumbers(
        Integer pageNumber,
        String countryCode,
        String stateCode,
        String phone,
        String ext,
        Boolean validateData
        ) {
        // find all numbers
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
        // paginate final result 
        return paginate.paginateResults(filteredResult, pageNumber, chunkSize) ;
    }
}
