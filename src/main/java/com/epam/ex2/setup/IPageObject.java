package com.epam.ex2.setup;

import org.openqa.selenium.WebElement;

public interface IPageObject {

    WebElement getWebElement(String weName) throws NoSuchFieldException, IllegalAccessException, InstantiationException;

}
