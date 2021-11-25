package com.ppkwu.lab4.services;

import com.ppkwu.lab4.utils.DataFormatType;
import org.json.CDL;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class DataConverterService {

    @Autowired
    private JsonConverterService jsonConverterService;

    public String convert(String data, String inputFormat, String outputFormat) {
        if(inputFormat.equals(outputFormat))
            return data;
        switch (inputFormat) {
            case DataFormatType.JSON:
                return jsonConverterService.convertTo(data, outputFormat);
            case DataFormatType.XML:
                return convertXmlTo(data, outputFormat);
            case DataFormatType.CSV:
                return convertCsvTo(data, outputFormat);
            case DataFormatType.TXT:
                return convertTxtTo(data, outputFormat);
            default:
                return "Incorrect input format";
        }
    }

    private String convertXmlTo(String xml, String format) {
        String json = XML.toJSONObject(xml).get("data").toString();
        if (format.equals(DataFormatType.JSON))
            return json;
        else if (format.equals(DataFormatType.CSV) || format.equals(DataFormatType.TXT))
            return jsonConverterService.convertTo(json, format);
        return null;
    }

    private String convertCsvTo(String csv, String format) {
        csv = csv.replaceAll("\\r", "");
        String json = CDL.toJSONArray(csv).get(0).toString();
        if (format.equals(DataFormatType.JSON))
            return json;
        else if (format.equals(DataFormatType.XML) || format.equals(DataFormatType.TXT))
            return jsonConverterService.convertTo(json, format);
        return null;
    }

    private String convertTxtTo(String txt, String format) {
        JSONObject jsonObject = new JSONObject();
        String[] lines = txt.split("\n");
        Pattern pattern = Pattern.compile("(\\w+): (\\S+)");
        for (String line : lines) {
            line = line.replaceAll("\\r", "");
            Matcher matcher = pattern.matcher(line);
            if (matcher.matches())
                jsonObject.put(matcher.group(1), matcher.group(2));
        }
        String json = jsonObject.toString();
        if (format.equals(DataFormatType.JSON))
            return json;
        else if (format.equals(DataFormatType.XML) || format.equals(DataFormatType.CSV))
            return jsonConverterService.convertTo(json, format);
        return null;
    }


}
