package com.qa.test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features", glue = "com.qa.stepdef", tags = "@CreateVisitPlanning or @ApproveVisitPlanningByBM", plugin = {"pretty", "html:./reports/report.html"})
public class ApproveVisitPlanningByBM extends AbstractTestNGCucumberTests {

}
