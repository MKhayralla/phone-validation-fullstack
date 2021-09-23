package com.jumia.phone.controller;

import com.jumia.phone.entity.PageResponse;
import com.jumia.phone.service.PhoneNumberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/numbers")
public class PhoneNumberController {
    @Autowired
    private PhoneNumberService service ;
    @GetMapping("/")
    @ResponseBody
    public PageResponse getNumbers(
        @RequestParam(name = "page", defaultValue = "1") String pageNumber,
        @RequestParam(name = "cc", defaultValue = "[0-9]*") String countryCode,
        @RequestParam(name = "sc", defaultValue = ".*") String stateCode,
        @RequestParam(name = "phone", defaultValue = ".*") String phone,
        @RequestParam(name = "ext", defaultValue = "") String ext,
        @RequestParam(name = "validate", defaultValue = "false") Boolean validateData
        ) {
        return service
        .getPhoneNumbers(
            Integer.parseInt(pageNumber),
            countryCode,
            stateCode,
            phone,
            ext,
            validateData
            ) ;
    }
}
