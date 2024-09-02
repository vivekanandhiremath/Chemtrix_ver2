package com.qa.test.visitplanning;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/resources/Features", glue = "com.qa.stepdef",
        tags = "@CreateVisitPlanningByBM", plugin = {"pretty", "com.qa.utils.CustomCucumberReportListener"}, monochrome = true)
public class CreateVisitPlanningByBM extends AbstractTestNGCucumberTests {

}
