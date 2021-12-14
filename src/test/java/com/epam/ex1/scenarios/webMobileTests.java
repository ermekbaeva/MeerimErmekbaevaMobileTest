package com.epam.ex1.scenarios;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.epam.ex1.setup.BaseTest;

import static com.epam.ex1.pageObjects.WebPageObject.*;

public class webMobileTests extends BaseTest {

    @Parameters({"searchData"})
    @Test(groups = {"web"}, description = "Make sure that we've get valid search results")
    public void simpleWebTest(String searchData) throws InterruptedException, NoSuchFieldException, IllegalAccessException, InstantiationException {
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
