package com.qa.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class WritePropertyFiles {

    private static String getFilePath(String context) {
        // Example logic to switch paths based on context
        switch (context) {
            case "cvpno":
                return System.getProperty("user.dir") + "/cvpno.properties";
            case "prod":
                return System.getProperty("user.dir") + "/prod-config.properties";
            default:
                return System.getProperty("user.dir") + "/default-config.properties";
        }
    }

    private static void writeToPropertyFile(String context, Map<String, String> properties) throws IOException {
        String filePath = getFilePath(context);
        Path path = Paths.get(filePath);
        // Ensure the directory exists
        Files.createDirectories(path.getParent());

        Properties pr = new Properties();
        // Set properties from the provided map
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            pr.setProperty(entry.getKey(), entry.getValue());
        }

        try (FileOutputStream fos = new FileOutputStream(path.toFile())) {
            pr.store(fos, "Test Data");
        }
    }

    public void write(String context, String attribute, String value) {
        try {
            Map<String, String> propertyMap = new HashMap<>();
            propertyMap.put(attribute, value);
            writeToPropertyFile(context, propertyMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
