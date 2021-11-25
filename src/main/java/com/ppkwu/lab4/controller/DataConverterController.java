package com.ppkwu.lab4.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataConverterController {

    @PostMapping("api/converter/{from}/{to}")
    public String convertDataFromTo(@PathVariable("from") String from, @PathVariable("to") String to) {
        return "test";
    }
}
