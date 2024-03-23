package com.book.store.api.data.providers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonDataReader {
    private String requestDataFolderPath = "src/main/resources/requestDataStatic/";
    public String getKeyValueFromJsonFile(String keyName, String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        String getKeyValueString = null;
        try {
            File jsonFile = new File(requestDataFolderPath + fileName);
            JsonNode rootNode = objectMapper.readTree(jsonFile);
            getKeyValueString = rootNode.get(keyName).toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("The fetched '"+keyName+"' key value from the the json file '"+fileName+"' is ={"+getKeyValueString+"}");
        return getKeyValueString;
    }
}
