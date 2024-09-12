package com.qa.pageobj;

import com.qa.utils.ElementUtils;
import com.qa.utils.PropertyReader;
import com.qa.utils.WritePropertyFiles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Properties;

import static com.qa.utils.CommonUtils.EXPLICIT_WAIT_BASIC_TIME;

public class CheckInCheckOut {
    @FindBy(xpath = "//button[contains(.,middle)]")
    List<WebElement> buttons;
    @FindBy(xpath = "//p")
    List<WebElement> officeInOfficeOut;
    private ElementUtils utils;
    private WebDriver ldriver;
    private Properties read;
    private WritePropertyFiles writeproperty;
    @FindBy(xpath = "//select[@id='ddSelectVisitType']")
    private WebElement selectvisittypedropdown;
    @FindBy(xpath = "//button[p[text()='Office IN']]")
    private WebElement officeINbutton;
    @FindBy(xpath = "//button[normalize-space()='Ok']")
    private WebElement okbutton;
    @FindBy(xpath = "//button[p[text()='Office Out']]")
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
        // Locate the "Office IN" and "Office OUT" buttons directly using CSS selectors

        // Check if the "Office IN" button is disabled
        boolean isOfficeInDisabled = officeINbutton.getAttribute("disabled") != null;

        // Check if the "Office OUT" button is disabled
        boolean isOfficeOutDisabled = officeOutButton.getAttribute("disabled") != null;

        // Click the enabled button
        if (!isOfficeInDisabled) {
            // Click the "Office IN" button if it is enabled
            System.out.println("Office IN button is enabled. Clicking on Office IN button.");
            officeINbutton.click();
            utils.clickOnElement(okbutton, EXPLICIT_WAIT_BASIC_TIME);
        } else if (!isOfficeOutDisabled) {
            // Click the "Office OUT" button if "Office IN" is disabled and "Office OUT" is enabled
            System.out.println("Office IN button is disabled. Clicking on Office OUT button.");
            clickOnOfficeOut();
        } else {
            // Both buttons are disabled
            System.out.println("Both Office IN and Office OUT buttons are disabled.");
        }
    }


    public void clickOnOfficeOut() {
        utils.clickOnElement(officeOutButton, EXPLICIT_WAIT_BASIC_TIME);
        utils.clickOnElement(okbutton, EXPLICIT_WAIT_BASIC_TIME);


    }


}
