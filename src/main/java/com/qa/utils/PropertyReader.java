package com.qa.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertyReader {
    //
//    private static ConfigReader instance;
//    private Properties prop;
//
//    // Private constructor to prevent instantiation
//    private ConfigReader() {
//        prop = new Properties();
//        try {
//            File proFile = new File(System.getProperty("user.dir") + "/config.properties");
//            FileInputStream fis = new FileInputStream(proFile);
//            prop.load(fis);
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
//    }
//
//    // Method to return the single instance of ConfigReader
//    public static ConfigReader getInstance() {
//        if (instance == null) {
//            instance = new ConfigReader();
//        }
//        return instance;
//    }
//
//    // Method to get properties
//    public Properties getProperties() {
//        return prop;
//    }
///////////////////////////////////////////////////////
    private static PropertyReader instance;
    private Properties prop;
    private String context;

    // Private constructor to prevent instantiation
    private PropertyReader(String context) {
        this.context = context;
        prop = new Properties();
        try {
            String filePath = getFilePath(context);
            Path path = Paths.get(filePath);
            // Ensure the file exists
            if (Files.notExists(path)) {
                throw new IOException("file not found: " + filePath);
            }
            try (FileInputStream fis = new FileInputStream(path.toFile())) {
                prop.load(fis);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file", e);
        }
    }

    // Method to get the file path based on the context
    private static String getFilePath(String context) {
        switch (context) {
            case "config":
                return System.getProperty("user.dir") + "/config.properties";
            case "prod":
                return System.getProperty("user.dir") + "/prod-config.properties";
            default:
                return System.getProperty("user.dir") + "/default-config.properties";
        }
    }

    // Method to return the single instance of ConfigReader
    public static synchronized PropertyReader getInstance(String context) {
        if (instance == null || !context.equals(instance.context)) {
            instance = new PropertyReader(context);
        }
        return instance;
    }

    // Method to get properties
    public Properties getProperties() {
        return prop;
    }


}
