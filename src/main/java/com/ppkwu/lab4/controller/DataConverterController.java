package com.ppkwu.lab4.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataConverterController {

    @PostMapping(value = "api/converter/{from}/json", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String convertDataToJson(@PathVariable("from") String from) {
        return "test";
    }

    @PostMapping(value = "api/converter/{from}/xml", produces = {MediaType.APPLICATION_XML_VALUE})
    public String convertDataToXml(@PathVariable("from") String from) {
        return "test2";
    }

    @PostMapping(value = "api/converter/{from}/csv", produces = {MediaType.TEXT_PLAIN_VALUE})
    public String convertDataToCsv(@PathVariable("from") String from) {
        return "test3";
    }

    @PostMapping(value = "api/converter/{from}/txt", produces = {MediaType.TEXT_PLAIN_VALUE})
    public String convertDataToTxt(@PathVariable("from") String from) {
        return "test4";
    }
}
