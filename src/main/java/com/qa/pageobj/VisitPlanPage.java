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

    public void clickOnMyActivity(){
        utils.clickOnElement(myactivitymenu,EXPLICIT_WAIT_BASIC_TIME);
    }
    @FindBy(xpath = "//p[normalize-space()='Visit Planning']")
    private WebElement visitplanningmenu;
    public void clickOnVisitPlanning(){
        utils.clickOnElement(visitplanningmenu,EXPLICIT_WAIT_BASIC_TIME);
    }
    @FindBy(xpath = "//p[@class='block antialiased font-sans text-base leading-relaxed text-white font-semibold']")
    private WebElement createvisitplanningbutton;

    public void clickOnCreateVisitPlanning(){
        utils.clickOnElement(createvisitplanningbutton,EXPLICIT_WAIT_BASIC_TIME);
    }

    @FindBy(xpath = "//input[@id='Autocomplete']")
    private WebElement customernametextfield;
    @FindBy(xpath="//input[@id='inputPhoneNumber']") private WebElement phonenumbernumfield;
    @FindBy(xpath="//input[@id='inputEmail']") private WebElement emailtextfield;
    @FindBy(xpath="//textarea[@id='TextAddress']") private WebElement addresstextfield;
    @FindBy(xpath="//input[@id=' Txt_Visit Date']") private WebElement visitdatedatefield;
    @FindBy(xpath="//input[@type='time']") private WebElement visittimetimefield;
    @FindBy(xpath="//select[@id='label_PurposeVisit']") private WebElement purposeofvisitdropdown;
    @FindBy(xpath="//textarea[@id='Remarks']") private WebElement remarkstextfield;

    public VisitPlanPage(WebDriver rdriver) {
        this.ldriver = rdriver;
        PageFactory.initElements(ldriver, this);
        utils = new ElementUtils(ldriver);
    }




    public void visitPlanning(VisitPlanning visitPlanning) {
utils.typeTextIntoElement(customernametextfield,visitPlanning.getCustomername(),EXPLICIT_WAIT_BASIC_TIME);
utils.typeTextIntoElement(phonenumbernumfield,visitPlanning.getPhonenumber(),EXPLICIT_WAIT_BASIC_TIME);

        utils.typeTextIntoElement(emailtextfield,visitPlanning.getEmail(),EXPLICIT_WAIT_BASIC_TIME);
        utils.typeTextIntoElement(addresstextfield,visitPlanning.getAddress(),EXPLICIT_WAIT_BASIC_TIME);
        utils.typeTextIntoElement(visitdatedatefield,visitPlanning.getVisitdate(),EXPLICIT_WAIT_BASIC_TIME);
        utils.typeTextIntoElement(visittimetimefield,visitPlanning.getVisittime(),EXPLICIT_WAIT_BASIC_TIME);
        selectPurposeOfVisit(visitPlanning.getPurposevisit());
        utils.typeTextIntoElement(remarkstextfield,visitPlanning.getRemarks(),EXPLICIT_WAIT_BASIC_TIME);
    }

private void selectPurposeOfVisit(PurposeOfVisit purposeofvisit){
        utils.selectOptionInDropdownByVisibleText(purposeofvisitdropdown,purposeofvisit.getDisplayValue(),EXPLICIT_WAIT_BASIC_TIME);
}

}



