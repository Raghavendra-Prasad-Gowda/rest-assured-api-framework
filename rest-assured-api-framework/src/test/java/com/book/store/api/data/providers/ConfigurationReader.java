package com.book.store.api.data.providers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private Properties properties;
    private static ConfigurationReader configReader;

    private ConfigurationReader() {
        BufferedReader reader;
        String propertyFilePath = "configuration/configuration.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("configuration.properties not found at " + propertyFilePath);
        }
    }

    public static ConfigurationReader getInstance() {
        if (configReader == null) {
            configReader = new ConfigurationReader();
        }
        return configReader;
    }

    public String getBaseurl() {
        String baseUrl = properties.getProperty("base_url");
        if (baseUrl != null) return baseUrl;
        else throw new RuntimeException("base_url not specified in the Configuration.properties file.");
    }

    public String getUserid() {
        String userId = properties.getProperty("user_id");
        if (userId != null) return userId;
        else throw new RuntimeException("user_id not specified in the Configuration.properties file.");
    }

    public String getUsername() {
        String username = properties.getProperty("username");
        if (username != null) return username;
        else throw new RuntimeException("username not specified in the Configuration.properties file.");
    }

    public String getPassword() {
        String password = properties.getProperty("password");
        if (password != null) return password;
        else throw new RuntimeException("password not specified in the Configuration.properties file.");
    }
}
