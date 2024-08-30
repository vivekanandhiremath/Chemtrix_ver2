package com.qa.test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/resources/Features", glue = "com.qa.stepdef",
        tags = "@Login", plugin = {"pretty", "com.qa.utils.CustomCucumberReportListener"}, monochrome = true)
public class LoginTest extends AbstractTestNGCucumberTests {

}
