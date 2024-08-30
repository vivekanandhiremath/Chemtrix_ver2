package com.qa.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelReader {

    public Map<String, String> getRowData(String key) {
        String excelFilePath;
        String sheetName;

        // Switch case to select Excel file path and sheet name based on the key
        switch (key) {
            case "login":
                excelFilePath = "src/test/resources/ExcelData/loginData.xlsx";
                sheetName = "login";
                break;
            case "userDetails":
                excelFilePath = "C:\\Users\\Splpt 708\\Documents\\userDetails.xlsx";
                sheetName = "UserInfo";
                break;
            // Add more cases as needed
            default:
                throw new IllegalArgumentException("Invalid key: " + key);
        }

        return readExcelData(excelFilePath, sheetName);
    }

    private Map<String, String> readExcelData(String excelFilePath, String sheetName) {
        Map<String, String> data = new HashMap<>();

        try (FileInputStream fis = new FileInputStream(excelFilePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new RuntimeException("Sheet with name " + sheetName + " does not exist.");
            }

            Row headerRow = sheet.getRow(0);
            Row dataRow = sheet.getRow(1);

            if (headerRow == null || dataRow == null) {
                throw new RuntimeException("The sheet does not contain enough data.");
            }

            int numberOfCells = headerRow.getPhysicalNumberOfCells();

            for (int i = 0; i < numberOfCells; i++) {
                Cell headerCell = headerRow.getCell(i);
                Cell dataCell = dataRow.getCell(i);

                if (headerCell != null && dataCell != null) {
                    String header = headerCell.getStringCellValue();
                    String value = dataCell.getStringCellValue();
                    data.put(header, value);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
