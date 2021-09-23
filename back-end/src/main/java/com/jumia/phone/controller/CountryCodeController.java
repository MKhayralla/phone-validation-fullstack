package com.jumia.phone.controller;

import java.util.Map;

import com.jumia.phone.service.ValidationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/codes")
public class CountryCodeController {
    @Autowired
    private ValidationService service ;
    @GetMapping("/")
    @ResponseBody
    Map<String, String> getCountryCodes() {
        return service.getCountryCodes() ;
    }
}
