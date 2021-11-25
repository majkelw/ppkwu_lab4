package com.ppkwu.lab4.services;

import com.ppkwu.lab4.utils.DataFormatType;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataConverterService {

    @Autowired
    private JsonConverterService jsonConverterService;

    public String convert(String data, String inputFormat, String outputFormat) {
        if (inputFormat.equals(DataFormatType.JSON))
            return jsonConverterService.convertTo(data, outputFormat);
        else if (inputFormat.equals(DataFormatType.XML))
            return convertXmlTo(data, outputFormat);
        return null;
    }

    public String convertXmlTo(String xml, String format) {
        String json = XML.toJSONObject(xml).get("data").toString();
        if (format.equals(DataFormatType.JSON))
            return json;
        else if (format.equals(DataFormatType.CSV) || format.equals(DataFormatType.TXT))
            return jsonConverterService.convertTo(json, DataFormatType.TXT);
        return null;
    }


}
