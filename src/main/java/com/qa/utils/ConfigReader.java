package com.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static ConfigReader instance;
    private Properties prop;

    // Private constructor to prevent instantiation
    private ConfigReader() {
        prop = new Properties();
        try {
            File proFile = new File(System.getProperty("user.dir") + "/config.properties");
            FileInputStream fis = new FileInputStream(proFile);
            prop.load(fis);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    // Method to return the single instance of ConfigReader
    public static ConfigReader getInstance() {
        if (instance == null) {
            instance = new ConfigReader();
        }
        return instance;
    }

    // Method to get properties
    public Properties getProperties() {
        return prop;
    }
}
