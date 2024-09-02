package com.qa.stepdef;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.base.WebdriverManager;
import com.qa.pageobj.CheckInCheckOut;
import com.qa.pageobj.HomePage;
import com.qa.pageobj.LoginPage;
import com.qa.pageobj.VisitPlanPage;
import com.qa.utils.LoginCredentials;
import com.qa.utils.PropertyReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Properties;

public class StepsDef {
    private Properties read;
    private Properties readcvpno;
    private WebDriver driver;
    private LoginPage lp;
    private VisitPlanPage vp;
    private HomePage hp;
    private ExtentTest scenarioTest;
    private LoginCredentials credentials;
    private CheckInCheckOut cicop;

    @Given("user is on login page")
    public void userIsOnLoginPage() {

        read = PropertyReader.getInstance("config").getProperties();


        driver = WebdriverManager.getInstance(read.getProperty("browser")).getDriver();
        lp = new LoginPage(driver);

        vp = new VisitPlanPage(driver);
        hp = new HomePage(driver);
        cicop = new CheckInCheckOut(driver);
        String actualValue = driver.getTitle();
        String expectedValue = "Chemtirix";

        try {
            Assert.assertEquals(actualValue, expectedValue, "Page didn't navigate to the Chemtirix application");
            if (scenarioTest != null) {
                scenarioTest.log(Status.PASS, "Assertion passed: Value is " + actualValue);
            }
        } catch (AssertionError e) {
            if (scenarioTest != null) {
                scenarioTest.log(Status.FAIL, "Assertion failed: " + e.getMessage());
            }
        }
    }


    @Then("TSM user Logs in to the application")
    public void userEnterUsernameAsAndPasswordAs() {
        // Using the Scenario object is fine, and it won't throw an error

        String username = read.getProperty("gc_tsm_user");
        String password = read.getProperty("password");
        lp.enterUserName(username);
        lp.enterPassword(password);
        lp.clickOnLogin();
        boolean text = hp.checkOnDashboard();
        Assert.assertTrue(text, "Login was not successful : Dashboard not displayed ");

    }


    @Then("user navigates to visit planning dashboard and click on create vsisit planning button")
    public void userNavigatesToVisitPlanningDashboardAndClickOnCreateVsisitPlanningButton() {

        vp.clickOnMyActivity();
        vp.clickOnVisitPlanning();
        vp.clickOnCreateVisitPlanning();

    }

    @Then("^user fills the visit planning details with customer type (.*) customer name (.*), phone number (.*), email (.*), address (.*), visit date (.*), visit time (.*), purpose of visit (.*), and remarks (.*)$")
    public void userFillsTheVisitPlanningDetailsWithCustomerTypeCustomertypeCustomerNameNamePhoneNumberPhnoEmailEmailAddressAddressVisitDateVisitdateVisitTimeVisisttimePurposeOfVisitPurposeAndRemarksRemarks(String customertype, String customername, String phno, String email, String address, String visitdate, String visittime, String purpose, String remarks) {
        vp.entervisitPlanningdetails(customertype, customername, phno, email, address, visitdate, visittime, purpose, remarks);
        vp.clickOnSubmitButton();
        vp.storeCVPNo();

    }

    @Then("user logs out of application")
    public void userLogsOutOfApplication() {
        hp.clickOnLogout();
    }

    @Then("user navigates to visit planning dashboard")
    public void userNavigatesToVisitPlanningDashboard() {
        hp.clickOnActivityMenu();
        vp.clickOnVisitPlanning();
    }


    @Then("^user filter record as (.*) for cvpno as (.*) and click on view button")
    public void userFilterRecordAsFiltertypeForCvpnoAsCvpnoAndClickOnViewButton(String filterby, String cvpno) {
        readcvpno = PropertyReader.getInstance("cvpno").getProperties();
        vp.filterAndSearchRecord(filterby, readcvpno.getProperty("cvpno"));
        vp.clickOnViewIcon();

    }

    @Then("BM Logs in to the application")
    public void bmLogsInToTheApplication() {

        String username = read.getProperty("bm_user");
        String password = read.getProperty("password");
        lp.enterUserName(username);
        lp.enterPassword(password);
        lp.clickOnLogin();
    }

    @Then("user approves the visit plan")
    public void userApprovesTheVisitPlan() {
        vp.clickOnApproveButton();

        hp.clickOnLogout();
    }

    @Then("^user logs in to application (.*)$")
    public void userLogsInToApplication(String key) {
        credentials = new LoginCredentials(key);
        String username = credentials.getUsername();
        String password = credentials.getPassword();

        System.out.println(username + " " + password);
    }


    /////////////////////////////////CheckInCheckOut////////////////////////////////////////////


    @Then("user naviagtes to CheckinCheckout page")
    public void UserNavigatesToCheckInCheckoutPage() {
        hp.navigateToCheckInCheckOut();

    }

    @Then("^user selects the visittype as (.*) and click on office in$")
    public void userselectThevisistType(String visittype) {
        cicop.selectVisittype(visittype);
    }


}
