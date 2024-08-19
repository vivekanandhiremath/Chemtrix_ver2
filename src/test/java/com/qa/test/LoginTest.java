package com.qa.test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features", glue = "com.qa.stepdef",
        plugin = {"pretty", "html:target/cucumber-reports.html"}, monochrome = true)
public class LoginTest extends AbstractTestNGCucumberTests {

}
