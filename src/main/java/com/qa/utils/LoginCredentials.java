package com.qa.utils;

import java.util.Map;

public class LoginCredentials {

    private String username;
    private String password;

    public LoginCredentials(String key) {
        ExcelReader excelReader = new ExcelReader();
        Map<String, String> data = excelReader.getRowData(key);

        this.username = data.get("Username");
        this.password = data.get("Password");
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
