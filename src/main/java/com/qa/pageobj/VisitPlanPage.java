package com.qa.pageobj;

import com.qa.utils.ElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.qa.utils.CommonUtils.EXPLICIT_WAIT_BASIC_TIME;

public class VisitPlanPage {

    private WebDriver ldriver;
    private ElementUtils utils;
    @FindBy(xpath = "//p[@class='block antialiased font-sans text-xs font-semibold capitalize text-primary'][normalize-space()='My Activity']")
    private WebElement myactivitymenu;
    @FindBy(xpath = "//p[normalize-space()='Visit Planning']")
    private WebElement visitplanningmenu;
    @FindBy(xpath = "//p[@class='block antialiased font-sans text-base leading-relaxed text-white font-semibold']")
    private WebElement createvisitplanningbutton;
    @FindBy(xpath = "//input[@id='Autocomplete']")
    private WebElement customernametextfield;
    @FindBy(xpath = "//input[@id='inputPhoneNumber']")
    private WebElement phonenumbernumfield;
    @FindBy(xpath = "//input[@id='inputEmail']")
    private WebElement emailtextfield;
    @FindBy(xpath = "//textarea[@id='TextAddress']")
    private WebElement addresstextfield;
    @FindBy(xpath = "//input[@id=' Txt_Visit Date']")
    private WebElement visitdatedatefield;
    @FindBy(xpath = "//input[@type='time']")
    private WebElement visittimetimefield;
    @FindBy(xpath = "//select[@id='label_PurposeVisit']")
    private WebElement purposeofvisitdropdown;
    @FindBy(xpath = "//textarea[@id='Remarks']")
    private WebElement remarkstextfield;
    @FindBy(xpath = "//li[@id='Autocomplete-option-0']")
    private WebElement customernamedropdownoption;
    @FindBy(xpath = "//button[@id='btn_AddEntry']")
    private WebElement addentrybutton;

    public VisitPlanPage(WebDriver rdriver) {
        this.ldriver = rdriver;
        PageFactory.initElements(ldriver, this);
        utils = new ElementUtils(ldriver);
    }

    public void clickOnMyActivity() {
        utils.clickOnElement(myactivitymenu, EXPLICIT_WAIT_BASIC_TIME);
    }

    public void clickOnVisitPlanning() {
        utils.clickOnElement(visitplanningmenu, EXPLICIT_WAIT_BASIC_TIME);
    }

    public void clickOnCreateVisitPlanning() {
        utils.clickOnElement(createvisitplanningbutton, EXPLICIT_WAIT_BASIC_TIME);
    }

    public void entervisitPlanningdetails(String customertype ,String customername, String phno, String email, String address, String visitdate, String visittime, String purposeofvisit, String remarks) {
        if(customertype.equalsIgnoreCase("sl")){
            searchCustomerName(customername);
//        utils.typeTextIntoElement(customernametextfield, customername, EXPLICIT_WAIT_BASIC_TIME);
            utils.typeTextIntoElement(visitdatedatefield, visitdate, EXPLICIT_WAIT_BASIC_TIME);
            utils.typeTextIntoElement(visittimetimefield, visittime, EXPLICIT_WAIT_BASIC_TIME);
            utils.typeTextIntoElement(purposeofvisitdropdown, visittime, EXPLICIT_WAIT_BASIC_TIME);
            selectPurposeOfVisit(purposeofvisit);
            utils.typeTextIntoElement(remarkstextfield, remarks, EXPLICIT_WAIT_BASIC_TIME);

        } else if (customertype.equalsIgnoreCase("pl")) {
            searchCustomerName(customername);
            utils.typeTextIntoElement(phonenumbernumfield, phno, EXPLICIT_WAIT_BASIC_TIME);
            utils.typeTextIntoElement(emailtextfield, email, EXPLICIT_WAIT_BASIC_TIME);
            utils.typeTextIntoElement(addresstextfield, address, EXPLICIT_WAIT_BASIC_TIME);
            utils.typeTextIntoElement(visitdatedatefield, visitdate, EXPLICIT_WAIT_BASIC_TIME);
            utils.typeTextIntoElement(visittimetimefield, visittime, EXPLICIT_WAIT_BASIC_TIME);
            utils.typeTextIntoElement(purposeofvisitdropdown, visittime, EXPLICIT_WAIT_BASIC_TIME);
            selectPurposeOfVisit(purposeofvisit);
            utils.typeTextIntoElement(remarkstextfield, remarks, EXPLICIT_WAIT_BASIC_TIME);
        }
    }

    private void selectPurposeOfVisit(String purpose) {
        utils.selectOptionInDropdownByVisibleText(purposeofvisitdropdown, purpose, EXPLICIT_WAIT_BASIC_TIME);
    }

    private void searchCustomerName(String customername) {
        utils.typeTextIntoElement(customernametextfield, customername, EXPLICIT_WAIT_BASIC_TIME);
        utils.clickOnElement(customernamedropdownoption, EXPLICIT_WAIT_BASIC_TIME);

    }



}



