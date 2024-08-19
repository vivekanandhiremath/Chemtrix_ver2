package com.qa.pageobj;

import com.qa.utils.ElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.qa.utils.CommonUtils.EXPLICIT_WAIT_BASIC_TIME;

public class LoginPage {

    private WebDriver ldriver;
    private ElementUtils utils;
    @FindBy(xpath = "//input[@placeholder='altrocks']")
    private WebElement usernametextfield;
    @FindBy(xpath = "//input[@placeholder='*******']")
    private WebElement passwordtextfield;
    @FindBy(xpath = "//button[@type='button']")
    private WebElement loginbutton;

    public LoginPage(WebDriver rdriver) {
        this.ldriver = rdriver;
        PageFactory.initElements(ldriver, this);
        utils = new ElementUtils(ldriver);
    }

    public void enterUserName(String textobetyped) {
        utils.typeTextIntoElement(usernametextfield, textobetyped, EXPLICIT_WAIT_BASIC_TIME);
    }

    public void enterPassword(String textobetyped) {
        utils.typeTextIntoElement(passwordtextfield, textobetyped, EXPLICIT_WAIT_BASIC_TIME);

    }

    public void clickOnLogin() {
        utils.clickOnElement(loginbutton, EXPLICIT_WAIT_BASIC_TIME);
    }


}
