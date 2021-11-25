package com.ppkwu.lab4.services;

import com.ppkwu.lab4.utils.DataFormatType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataConverterService {

    @Autowired
    private JsonConverterService jsonConverterService;

    public String convert(String data, String inputFormat, String outputFormat) {
        if (inputFormat.equals(DataFormatType.JSON))
            return jsonConverterService.convertTo(data, outputFormat);
        return null;
    }


}
