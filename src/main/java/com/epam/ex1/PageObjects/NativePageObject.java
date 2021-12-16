package com.epam.ex1.PageObjects;

import com.epam.ex1.setup.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NativePageObject extends BaseTest {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
    WebElement signInButton;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    WebElement registerButton;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
    WebElement emailInput;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
    WebElement usernameInput;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_password")
    WebElement passwordInput;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_confirm_password")
    WebElement confirmPasswordInput;
    @AndroidFindBy(className = "android.widget.CheckedTextView")
    WebElement confirmAgreementsCheckbox;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_new_account_button")
    WebElement registerNewAccButton;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_email")
    WebElement loginEmailInput;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_pwd")
    WebElement loginPasswordInput;
    @AndroidFindBy(xpath = "//*[@resource-id='platkovsky.alexey.epamtestapp:id/action_bar']//android.widget.TextView")
    WebElement pageDescription;

    public NativePageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public static void registerNewUser(String email, String username, String password) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        getPageObject().getWebElement("registerButton").click();
        getPageObject().getWebElement("emailInput").sendKeys(email);
        getPageObject().getWebElement("usernameInput").sendKeys(username);
        getPageObject().getWebElement("passwordInput").sendKeys(password);
        getPageObject().getWebElement("confirmPasswordInput").sendKeys(password);
        getPageObject().getWebElement("confirmAgreementsCheckbox").click();
        getPageObject().getWebElement("registerNewAccButton").click();
    }

    public static void login(String email, String password) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        getPageObject().getWebElement("loginEmailInput").sendKeys(email);
        getPageObject().getWebElement("loginPasswordInput").sendKeys(password);
        getPageObject().getWebElement("signInButton").click();
    }

    public static String getDescriptionOfPage() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        return getWebDriverWait()
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOf(getPageObject().getWebElement("pageDescription"))).getText();
    }
}
