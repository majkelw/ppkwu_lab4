package com.ppkwu.lab4.controller;

import com.ppkwu.lab4.services.DataConverterService;
import com.ppkwu.lab4.utils.DataFormatType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataConverterController {

    @Autowired
    private DataConverterService dataConverterService;

    @PostMapping(value = "api/converter/{from}/json", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String convertDataToJson(@RequestBody String data, @PathVariable("from") String from) {
        return dataConverterService.convert(data, from, DataFormatType.JSON);
    }

    @PostMapping(value = "api/converter/{from}/xml", produces = {MediaType.APPLICATION_XML_VALUE})
    public String convertDataToXml(@RequestBody String data, @PathVariable("from") String from) {
        return dataConverterService.convert(data, from, DataFormatType.XML);
    }

    @PostMapping(value = "api/converter/{from}/csv", produces = {MediaType.TEXT_PLAIN_VALUE})
    public String convertDataToCsv(@RequestBody String data, @PathVariable("from") String from) {
        return dataConverterService.convert(data, from, DataFormatType.CSV);
    }

    @PostMapping(value = "api/converter/{from}/txt", produces = {MediaType.TEXT_PLAIN_VALUE})
    public String convertDataToTxt(@RequestBody String data, @PathVariable("from") String from) {
        return dataConverterService.convert(data, from, DataFormatType.TXT);
    }
}
