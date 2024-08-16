package com.qa.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class WritePropertyFiles {

    public static void writeToPropertyFile(String filePath, Map<String, String> properties) throws IOException {
        File file = new File(filePath);
        file.createNewFile();

        Properties pr = new Properties();

        // Set properties from the provided map
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            pr.setProperty(entry.getKey(), entry.getValue());
        }

        FileOutputStream fis = new FileOutputStream(file);
        pr.store(fis, "Test Data");

        fis.close();
    }

    public void write(String attribute, String value) {
        try {
            String path = System.getProperty("user.dir") + "\\src\\test\\resources\\config\\salesquotno.properties";
            Map<String, String> propertyMap = new HashMap<>();
            propertyMap.put(attribute, value);

            writeToPropertyFile(path, propertyMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
