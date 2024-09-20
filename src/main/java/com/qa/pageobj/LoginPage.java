package com.qa.pageobj;

import com.qa.utils.ElementUtils;
import org.openqa.selenium.NoSuchElementException;
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

    @FindBy(xpath = "//img[@src='/img/warning.png']")
    private WebElement loginpopup;


    @FindBy(xpath = "//button[normalize-space()='Ok']")
    private WebElement popupokbutton;

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


    ///////////////////////////
    public boolean isUserAlreadyLoggedInPopupDisplayed() {
        // Implement the logic to check if the "user already logged in" popup is visible
        // For example, locate the popup by its XPath, CSS Selector, etc.
        try {
Thread.sleep(2000);
            return loginpopup.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void clickOnPopUpOKButton() {
        utils.clickOnElement(popupokbutton, EXPLICIT_WAIT_BASIC_TIME);
    }


}
