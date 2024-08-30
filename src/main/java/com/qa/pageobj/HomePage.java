package com.qa.pageobj;

import com.qa.utils.ElementUtils;
import com.qa.utils.WritePropertyFiles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

import static com.qa.utils.CommonUtils.EXPLICIT_WAIT_BASIC_TIME;

public class HomePage {
    private ElementUtils utils;
    private WebDriver ldriver;
    private Properties prop;
    private WritePropertyFiles writproperty;
    @FindBy(xpath = "//div[@id='Log-menu']")
    private WebElement logoutDropdown;
    @FindBy(xpath = "//p[@id='Logout']")
    private WebElement logoutButton;
    @FindBy(xpath = "//p[@class='block antialiased font-sans text-xs font-semibold capitalize text-primary'][normalize-space()='My Activity']")
    private WebElement myactivitymenu;
    @FindBy(xpath = "//div[@class='capitalize']")
    private WebElement welcometxt;

    public HomePage(WebDriver rdriver) {
        this.ldriver = rdriver;
        PageFactory.initElements(ldriver, this);
        utils = new ElementUtils(ldriver);
    }

    public void clickOnLogout() {
        utils.clickOnElement(logoutDropdown, EXPLICIT_WAIT_BASIC_TIME);
        utils.clickOnElement(logoutButton, EXPLICIT_WAIT_BASIC_TIME);

    }

    public void clickOnActivityMenu() {

        utils.mouseHoverAndClick(myactivitymenu, EXPLICIT_WAIT_BASIC_TIME);
    }

    public boolean checkOnDashboard() {
        boolean text = utils.displayStatusOfElement(welcometxt, EXPLICIT_WAIT_BASIC_TIME);
        return text;
    }
}
