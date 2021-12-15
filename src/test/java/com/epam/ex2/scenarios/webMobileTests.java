package com.epam.ex2.scenarios;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.epam.ex2.setup.BaseTest;

import static com.epam.ex2.pageObjects.WebPageObject.enterSearchData;
import static com.epam.ex2.pageObjects.WebPageObject.getResults;

public class webMobileTests extends BaseTest {

    @Parameters({"searchData"})
    @Test(groups = {"web"}, description = "Make sure that we've opened IANA homepage")
    public void simpleWebTest(String searchData) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        System.out.println("begin");
        getDriver().get("http://www.google.com"); // open Google homepage

        // Make sure that page has been loaded completely
        new WebDriverWait(getDriver(), 10).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );
        enterSearchData(searchData);
        new WebDriverWait(getDriver(), 10).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );
        assert (getResults().stream().anyMatch(str -> str.trim().contains(searchData)));

        // Log that test finished
        System.out.println("Site opening done");
    }
}
