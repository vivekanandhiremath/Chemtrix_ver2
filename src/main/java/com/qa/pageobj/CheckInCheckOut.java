package com.qa.pageobj;

import com.qa.utils.ElementUtils;
import com.qa.utils.PropertyReader;
import com.qa.utils.WritePropertyFiles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

import static com.qa.utils.CommonUtils.EXPLICIT_WAIT_BASIC_TIME;

public class CheckInCheckOut {
    private ElementUtils utils;
    private WebDriver ldriver;
    private Properties read;
    private WritePropertyFiles writeproperty;


    @FindBy(xpath = "//select[@id='ddSelectVisitType']")
    private WebElement selectvisittypedropdown;
    @FindBy(xpath = "//p[normalize-space()='Office IN']")
    private WebElement officeINbutton;
    @FindBy(xpath = "//button[normalize-space()='Ok']")
    private WebElement okbutton;
    @FindBy(xpath = "//p[normalize-space()='Office Out']")
    private WebElement officeOutButton;

    public CheckInCheckOut(WebDriver rdriver) {
        this.ldriver = rdriver;
        PageFactory.initElements(ldriver, this);
        utils = new ElementUtils(ldriver);
        read = PropertyReader.getInstance("config").getProperties();
        writeproperty = new WritePropertyFiles();
    }

    public void selectVisittype(String visittype) {
        utils.selectOptionInDropdownByVisibleText(selectvisittypedropdown, visittype, EXPLICIT_WAIT_BASIC_TIME);
    }

    public void clickOnOfficeIn() {

        boolean result = utils.checkElementIsEnabled(officeINbutton, EXPLICIT_WAIT_BASIC_TIME);
        System.out.println(result);

        if (result == false) {
            utils.clickOnElement(officeINbutton, EXPLICIT_WAIT_BASIC_TIME);
            utils.clickOnElement(okbutton, EXPLICIT_WAIT_BASIC_TIME);
        } else {
            System.out.println("since the user already is checked into office now user is checking out of office");
            clickOnOfficeOut();
        }


    }


    public void clickOnOfficeOut() {
        utils.clickOnElement(officeOutButton, EXPLICIT_WAIT_BASIC_TIME);
        utils.clickOnElement(okbutton, EXPLICIT_WAIT_BASIC_TIME);


    }


}
