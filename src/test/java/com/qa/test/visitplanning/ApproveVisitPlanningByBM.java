package com.qa.test.visitplanning;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features",
        glue = "com.qa.stepdef", tags = "@CreateVisitPlanningByTSM or @ApproveVisitPlanningByBM",
        plugin = {"pretty", "com.qa.utils.CustomCucumberReportListener"})
public class ApproveVisitPlanningByBM extends AbstractTestNGCucumberTests {

}
