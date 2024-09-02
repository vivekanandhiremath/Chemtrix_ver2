package com.qa.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;

public class CustomCucumberReportListener implements ConcurrentEventListener {
    private ExtentReports extent;
    private ExtentTest featureTest;
    private ExtentTest scenarioTest;
    private String currentFeatureName;
    private String currentScenarioName;

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestCaseStarted.class, this::handleTestCaseStarted);
        publisher.registerHandlerFor(TestStepFinished.class, this::handleTestStepFinished);
        publisher.registerHandlerFor(TestCaseFinished.class, this::handleTestCaseFinished);
    }

    private void handleTestCaseStarted(TestCaseStarted event) {
        String featureName = extractFeatureName(event.getTestCase().getUri().getPath());
        String scenarioName = event.getTestCase().getName();

        // Check if the feature name has changed or is being initialized for the first time
        if (currentFeatureName == null || !currentFeatureName.equals(featureName)) {
            currentFeatureName = featureName;
            String reportFileName = featureName + "_" + CommonUtils.getReportFilenameWithTimeStamp();
            extent = ExtentManager.getExtentReports(reportFileName);
            featureTest = extent.createTest(featureName);
        }

        // Ensure featureTest is not null before creating scenarioTest
//        if (featureTest != null) {
        scenarioTest = featureTest.createNode(scenarioName);
//        } else {
        // Handle the case where featureTest is null (shouldn't usually happen if initialization is correct)
//            System.err.println("Feature test is not initialized. Scenario test cannot be created.");
//        }
    }


    private void handleTestStepFinished(TestStepFinished event) {
        Status stepStatus = mapCucumberStatusToExtentStatus(event.getResult().getStatus());
        String stepName = getStepName(event.getTestStep());

        if (stepStatus == Status.PASS) {
            scenarioTest.log(Status.PASS, stepName);
        } else if (stepStatus == Status.FAIL) {
            scenarioTest.log(Status.FAIL, stepName + "\n" + event.getResult().getError().getMessage());
        } else if (stepStatus == Status.SKIP) {
            scenarioTest.log(Status.SKIP, stepName);
        }
    }

    private void handleTestCaseFinished(TestCaseFinished event) {
        extent.flush();
    }

    private String extractFeatureName(String featurePath) {
        String[] pathParts = featurePath.split("/");
        return pathParts[pathParts.length - 1].replace(".feature", "");
    }

    private Status mapCucumberStatusToExtentStatus(io.cucumber.plugin.event.Status cucumberStatus) {
        switch (cucumberStatus) {
            case PASSED:
                return Status.PASS;
            case FAILED:
                return Status.FAIL;
            case SKIPPED:
            case PENDING:
                return Status.SKIP;
            case UNDEFINED:
            case AMBIGUOUS:
                return Status.WARNING;
            default:
                return Status.SKIP;
        }
    }

    private String getStepName(TestStep testStep) {
        if (testStep instanceof PickleStepTestStep) {
            return ((PickleStepTestStep) testStep).getStep().getText();
        } else if (testStep instanceof HookTestStep) {
            String hookType = ((HookTestStep) testStep).getHookType().toString();
            return "Hook (" + hookType + "): " + testStep.getCodeLocation();
        }
        return "Unknown Step";
    }
}
