package com.epam.ex1.PageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

import static com.epam.ex1.setup.BaseTest.getPageObject;

public class WebPageObject {

    @FindBy(css = ".gLFyf")
    WebElement searchInput;
    @FindBy(css = ".z1asCe")
    WebElement searchButton;
    @FindBy(xpath = "//span[text()='epam']")
    WebElement searchResults;
    @FindBy(xpath = "//span[contains(text(),'epam')]")
    static List<WebElement> resultLinks;

    public WebPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
    }

    public static void enterSearchData(String data)
            throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        getPageObject().getWebElement("searchInput").sendKeys(data);
        getPageObject().getWebElement("searchInput").sendKeys(Keys.ENTER);
    }

    public static List<String> getResults() {
        return resultLinks.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
