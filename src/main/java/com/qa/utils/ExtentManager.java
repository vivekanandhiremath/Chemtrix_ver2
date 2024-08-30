package com.qa.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentManager {

    // Create a new ExtentReports instance for each report
    public synchronized static ExtentReports getExtentReports(String reportFileName) {
        ExtentReports extent = new ExtentReports();

        // Ensure the directory exists
        File reportDir = new File("reports/extentReport/");
        if (!reportDir.exists()) {
            reportDir.mkdirs(); // Create directories if they don't exist
        }

        // Initialize the ExtentSparkReporter with the dynamic filename
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportDir.getPath() + "/" + reportFileName);

        // Customize the report (optional)
        sparkReporter.config().setReportName("Automation Test Report");
        sparkReporter.config().setDocumentTitle("Test Results");

        // Attach the reporter to the ExtentReports instance
        extent.attachReporter(sparkReporter);

        // Add system information (optional)
        extent.setSystemInfo("Tester", "Vivekanand Hiremath");
        extent.setSystemInfo("Environment", "QA");

        return extent;
    }

    // Flush the reports and clean up
    public synchronized static void flushReports(ExtentReports extent) {
        if (extent != null) {
            extent.flush();
        }
    }
}







