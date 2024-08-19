package com.qa.pageobj;

import com.qa.utils.ElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.qa.utils.CommonUtils.EXPLICIT_WAIT_BASIC_TIME;

public class HomePage {
    private ElementUtils utils;
    private WebDriver ldriver;
    @FindBy(xpath = "//div[@id='Log-menu']")
    private WebElement logoutDropdown;
    @FindBy(xpath = "//p[@id='Logout']")
    private WebElement logoutButton;

    public HomePage(WebDriver rdriver) {
        this.ldriver = rdriver;
        PageFactory.initElements(ldriver, this);
        utils = new ElementUtils(ldriver);
    }

    public void clickOnLogout() {
        utils.clickOnElement(logoutDropdown, EXPLICIT_WAIT_BASIC_TIME);
        utils.clickOnElement(logoutButton, EXPLICIT_WAIT_BASIC_TIME);

    }
}
