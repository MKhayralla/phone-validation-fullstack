package com.jumia.phone.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.jumia.phone.entity.PhoneNumber;

import org.springframework.stereotype.Service;

@Service
public class ValidationService {
    public Map<String, String> getCountryCodes () {
        Map<String, String> countriesMap = new HashMap<>() ;
        countriesMap.put("MOR", "212") ;
        countriesMap.put("CAM", "237") ;
        countriesMap.put("ETH", "251") ;
        countriesMap.put("MOZ", "258") ;
        countriesMap.put("UGA", "256") ;
        return countriesMap ;
    }
    private String getFilteringRegex(
        String countryCode,
        String stateCode,
        String phone,
        String ext
    ) {
        String regex = new StringBuilder()
        .append("^\\(")
        .append(countryCode)
        .append("\\)\\ ?")
        .append(stateCode)
        .append(".*")
        .append(phone)
        .append(".*")
        .append(ext)
        .append(".*$")
        .toString() ;
        return regex ;
    }
    private String getValidatingRegex() {
        String regex = new StringBuilder()
        .append("\\(237\\)\\ ?[2368]\\d{7,8}$")
        .append("|")
        .append("\\(251\\)\\ ?[1-59]\\d{8}$")
        .append("|")
        .append("\\(212\\)\\ ?[5-9]\\d{8}$")
        .append("|")
        .append("\\(258\\)\\ ?[28]\\d{7,8}$")
        .append("|")
        .append("\\(256\\)\\ ?\\d{9}$")
        .toString() ;
        return regex ;
    }
    public List<PhoneNumber> validate(List<PhoneNumber> numbers) {
        String validationString = this.getValidatingRegex() ;
        return numbers.stream()
        .filter((number) -> {return number.getPhone().matches(validationString) ;})
        .collect(Collectors.toList()) ;
    }
    public List<PhoneNumber> Filter(
        List<PhoneNumber> numbers,
        String countryCode,
        String stateCode,
        String phone,
        String ext
        ) {
        String filteringString = this.getFilteringRegex(countryCode, stateCode, phone, ext) ;
        return numbers.stream()
        .filter((number) -> {return number.getPhone().matches(filteringString) ;})
        .collect(Collectors.toList()) ;
    }
    public List<PhoneNumber> validateAndFilter(
        List<PhoneNumber> numbers,
        String countryCode,
        String stateCode,
        String phone,
        String ext
        ) {
        String validationString = this.getValidatingRegex() ;
        String filteringString = this.getFilteringRegex(countryCode, stateCode, phone, ext) ;
        return numbers.stream()
        .filter((number) -> {return number.getPhone().matches(validationString) ;})
        .filter((number) -> {return number.getPhone().matches(filteringString) ;})
        .collect(Collectors.toList()) ;
    }
}
