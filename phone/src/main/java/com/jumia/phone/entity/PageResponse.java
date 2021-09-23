package com.jumia.phone.entity;

import java.util.List;

public class PageResponse {
    private Integer numberOfPages ;
    private List<PhoneNumber> PhoneNumbers ;
    public PageResponse(Integer numberOfPages, List<PhoneNumber> phoneNumbers) {
        this.numberOfPages = numberOfPages;
        PhoneNumbers = phoneNumbers;
    }
    public PageResponse() {
    }
    public Integer getNumberOfPages() {
        return numberOfPages;
    }
    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
    public List<PhoneNumber> getPhoneNumbers() {
        return PhoneNumbers;
    }
    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        PhoneNumbers = phoneNumbers;
    }
    
}
