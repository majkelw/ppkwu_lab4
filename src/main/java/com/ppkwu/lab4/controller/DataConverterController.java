package com.ppkwu.lab4.controller;

import com.ppkwu.lab4.services.ClientService;
import com.ppkwu.lab4.services.DataConverterService;
import com.ppkwu.lab4.utils.DataFormatType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class DataConverterController {

    @Autowired
    private DataConverterService dataConverterService;

    @Autowired
    private ClientService clientService;


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


    @GetMapping(value = "api/stats/{download_format}/json/string", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String printStringStatsFromServiceAsJson
            (@PathVariable("download_format") String downloadFormat, @RequestParam("str") String str) {
        String downloadedData = clientService.getStringStats(downloadFormat, str).block();
        return dataConverterService.convert(downloadedData, downloadFormat, DataFormatType.JSON);
    }

    @GetMapping(value = "api/stats/{download_format}/xml/string", produces = {MediaType.APPLICATION_XML_VALUE})
    public String printStringStatsFromServiceAsXml
            (@PathVariable("download_format") String downloadFormat, @RequestParam("str") String str) {
        String downloadedData = clientService.getStringStats(downloadFormat, str).block();
        return dataConverterService.convert(downloadedData, downloadFormat, DataFormatType.XML);
    }

    @GetMapping(value = "api/stats/{download_format}/csv/string", produces = {MediaType.TEXT_PLAIN_VALUE})
    public String printStringStatsFromServiceAsCsv
            (@PathVariable("download_format") String downloadFormat, @RequestParam("str") String str) {
        String downloadedData = clientService.getStringStats(downloadFormat, str).block();
        return dataConverterService.convert(downloadedData, downloadFormat, DataFormatType.CSV);
    }

    @GetMapping(value = "api/stats/{download_format}/txt/string", produces = {MediaType.TEXT_PLAIN_VALUE})
    public String printStringStatsFromServiceAsTxt
            (@PathVariable("download_format") String downloadFormat, @RequestParam("str") String str) {
        String downloadedData = clientService.getStringStats(downloadFormat, str).block();
        return dataConverterService.convert(downloadedData, downloadFormat, DataFormatType.TXT);
    }
}
