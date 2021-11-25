package com.ppkwu.lab4.services;

import com.ppkwu.lab4.utils.DataFormatType;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Service;

@Service
public class JsonConverterService {

    public String convertTo(String json, String format) {
        switch (format) {
            case DataFormatType.XML:
                return toXml(json);
            case DataFormatType.CSV:
                return toCsv(json);
            case DataFormatType.TXT:
                return toTxt(json);
            default:
                return "Incorrect input format";
        }
    }

    private String toXml(String json) {
        return "<data>" + XML.toString(new JSONObject(json)) + "</data>";
    }

    private String toCsv(String json) {
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(new JSONObject(json));
        return CDL.toString(jsonArray);
    }

    private String toTxt(String json) {
        JSONObject jsonObject = new JSONObject(json);
        StringBuilder txt = new StringBuilder();
        jsonObject.keySet().forEach(key -> {
            Object value = jsonObject.get(key);
            txt.append(key).append(": ").append(value).append("\n");
        });
        if (txt.length() > 0)
            txt.deleteCharAt(txt.length() - 1);
        return txt.toString();
    }

}

