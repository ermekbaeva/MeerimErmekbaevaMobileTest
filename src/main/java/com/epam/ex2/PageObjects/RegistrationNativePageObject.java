package com.epam.ex2.PageObjects;

import com.epam.ex2.setup.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class RegistrationNativePageObject extends BaseTest {
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

    public RegistrationNativePageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public static void registerNewUser(String email, String username, String password)
            throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        getPageObject().getWebElement("emailInput").sendKeys(email);
        getPageObject().getWebElement("usernameInput").sendKeys(username);
        getPageObject().getWebElement("passwordInput").sendKeys(password);
        getPageObject().getWebElement("confirmPasswordInput").sendKeys(password);
        getPageObject().getWebElement("confirmAgreementsCheckbox").click();
        getPageObject().getWebElement("registerNewAccButton").click();
    }
}
