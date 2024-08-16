package com.qa.stepdef;

import com.qa.base.WebdriverManager;
import com.qa.pageobj.LoginPage;
import com.qa.utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class StepsDef {
    private Properties prop;
    private WebDriver driver;
    private LoginPage lp;

    @Given("user is on login page")
    public void userIsOnLoginPage() {

        prop = ConfigReader.getInstance().getProperties();

        // Initialize the WebDriver using the browser property
        driver = WebdriverManager.getInstance(prop.getProperty("browser")).getDriver();
        lp = new LoginPage(driver);

    }

    @Then("user enter username as {string}")
    public void userEnterUsernameAs(String username) {
        lp.enterUserName(username);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
