package com.qa.test.checkincheckout;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/resources/Features", glue = "com.qa.stepdef",
        tags = "@OfficIn", plugin = {"pretty", "com.qa.utils.CustomCucumberReportListener"}, monochrome = true)
public class OfficeVisitByTSM extends AbstractTestNGCucumberTests {

}
