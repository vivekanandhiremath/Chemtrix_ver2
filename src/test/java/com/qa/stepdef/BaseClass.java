package com.qa.stepdef;

import com.qa.base.WebdriverManager;
import com.qa.utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class BaseClass {

    private WebDriver driver;
    private Properties prop;

    @Before
    public void setup() {
        // Load properties using the Singleton instance
        prop = ConfigReader.getInstance().getProperties();

        // Initialize the WebDriver using the browser property
        driver = WebdriverManager.getInstance(prop.getProperty("browser")).getDriver();

        // Maximize the browser window and navigate to the URL
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
    }

    @After
    public void tearDown(Scenario scenario) throws InterruptedException {
        String scenarioName = scenario.getName().replaceAll(" ", "_");


        if (scenario.isFailed()) {
            // Capture screenshot if the scenario fails
            byte[] srcScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(srcScreenshot, "image/png", scenarioName);
        }

        // Quit the browser after the scenario
        WebdriverManager.quitBrowser();
    }
}
