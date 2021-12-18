package com.epam.ex2.PageObjects;

import com.epam.ex2.setup.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NativePageObject extends BaseTest {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Sign In']")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
    WebElement signInButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Register new account']")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    WebElement registerButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='user@example.com']")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
    WebElement emailInput;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='TimApple']")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
    WebElement usernameInput;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Required']")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_password")
    WebElement passwordInput;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Repeat please']")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_confirm_password")
    WebElement confirmPasswordInput;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@value='0']")
    @AndroidFindBy(className = "android.widget.CheckedTextView")
    WebElement confirmAgreementsCheckbox;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@enabled='true']")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_new_account_button")
    WebElement registerNewAccButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='user@example.com']")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_email")
    WebElement loginEmailInput;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Required']")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_pwd")
    WebElement loginPasswordInput;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Budget']")
    @AndroidFindBy(xpath = "//*[@resource-id='platkovsky.alexey.epamtestapp:id/action_bar']//android.widget.TextView")
    WebElement pageDescription;

    public NativePageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public static void goToRegistrationPage() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        getPageObject().getWebElement("registerButton").click();
    }

    public static void registerNewUser(String email, String username, String password)
            throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        getPageObject().getWebElement("emailInput").sendKeys(email);
        getPageObject().getWebElement("usernameInput").sendKeys(username);
        getPageObject().getWebElement("passwordInput").sendKeys(password);
        getPageObject().getWebElement("confirmPasswordInput").sendKeys(password);
        getPageObject().getWebElement("confirmAgreementsCheckbox").click();
        getPageObject().getWebElement("registerNewAccButton").click();
        //getPageObject().getWebElement("registerNewAccButton").click();
    }

    public static void login(String email, String password) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(getPageObject().getWebElement("loginEmailInput"))).sendKeys(email);
        getPageObject().getWebElement("loginPasswordInput").sendKeys(password);
        getPageObject().getWebElement("signInButton").click();
    }

    public static String getDescriptionOfPage()
            throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        return getWebDriverWait()
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOf(getPageObject().getWebElement("pageDescription")))
                .getText();
    }
}
