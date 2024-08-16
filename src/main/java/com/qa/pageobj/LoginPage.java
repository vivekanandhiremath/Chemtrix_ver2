package com.qa.pageobj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver ldriver;
    @FindBy(xpath = "//input[@placeholder='altrocks']")
    private WebElement usernametextfield;
    @FindBy(xpath = "//input[@placeholder='*******']")
    private WebElement passwordtextfield;
    @FindBy(xpath = "//button[@type='button']")
    private WebElement loginbutton;

    public LoginPage(WebDriver rdriver) {
        this.ldriver = rdriver;
        PageFactory.initElements(ldriver, this);
    }

    public void enterUserName(String textobetyped) {
        usernametextfield.sendKeys(textobetyped);
    }
}
