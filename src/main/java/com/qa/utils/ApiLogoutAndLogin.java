package com.qa.utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.pageobj.ApiLogout;
import com.qa.pageobj.LoginPage;
import com.qa.utils.ExcelReader;

import java.util.Map;

public class ApiLogoutAndLogin {

    private LoginPage lp;
    private String username;
    private String password;
    private ExtentTest scenarioTest;
    public ApiLogoutAndLogin(LoginPage lp, ExcelReader excelReader, String key) {
        this.lp = lp;
        Map<String, String> loginData = excelReader.getRowData(key);
        this.username = loginData.get("Username");
        this.password = loginData.get("Password");
    }
    public ApiLogoutAndLogin(LoginPage lp, String username, String password) {
        this.lp = lp;
        this.username = username;
        this.password = password;
    }
    public void handleLogin() {
        lp.enterUserName(username);
        lp.enterPassword(password);
        lp.clickOnLogin();

        boolean check = lp.isUserAlreadyLoggedInPopupDisplayed();
        System.out.println(check);

        if (check) {
            // Log out via API
            ApiLogout apiLogout = new ApiLogout();
            String response = apiLogout.logoutUser(username);

            if (response != null) {
                System.out.println("User logged out via API.");

                // Optional wait to ensure session is cleared
                try {
                    Thread.sleep(2000); // Wait for 2 seconds (adjust as needed)
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                // Log status in Extent Report
                if (scenarioTest != null) {
                    scenarioTest.log(Status.INFO, "User was already logged in. Logged out successfully for user: " + username);
                }

                lp.clickOnPopUpOKButton();

                // Retry login after successful logout
                retryLogin(username, password);
            } else {
                System.out.println("Logout was not successful, cannot retry login.");
            }
        }
    }

    private void retryLogin(String username, String password) {
        lp.enterUserName(username);
        lp.enterPassword(password);
        lp.clickOnLogin();
        System.out.println("Retrying login after logout.");
    }
}
