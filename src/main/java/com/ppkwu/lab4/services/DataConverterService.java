package com.ppkwu.lab4.services;

import com.ppkwu.lab4.utils.DataFormatType;
import org.json.CDL;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataConverterService {

    @Autowired
    private JsonConverterService jsonConverterService;

    public String convert(String data, String inputFormat, String outputFormat) {
        switch (inputFormat) {
            case DataFormatType.JSON:
                return jsonConverterService.convertTo(data, outputFormat);
            case DataFormatType.XML:
                return convertXmlTo(data, outputFormat);
            case DataFormatType.CSV:
                return convertCsvTo(data, outputFormat);
        }
        return null;
    }

    public String convertXmlTo(String xml, String format) {
        String json = XML.toJSONObject(xml).get("data").toString();
        if (format.equals(DataFormatType.JSON))
            return json;
        else if (format.equals(DataFormatType.CSV) || format.equals(DataFormatType.TXT))
            return jsonConverterService.convertTo(json, format);
        return null;
    }

    public String convertCsvTo(String csv, String format) {
        csv = csv.replaceAll("\\r", "");
        String json = CDL.toJSONArray(csv).get(0).toString();
        if (format.equals(DataFormatType.JSON))
            return json;
        else if (format.equals(DataFormatType.XML) || format.equals(DataFormatType.TXT))
            return jsonConverterService.convertTo(json, format);
        return null;
    }


}
