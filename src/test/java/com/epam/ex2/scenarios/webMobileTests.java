package com.epam.ex2.scenarios;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.epam.ex2.setup.BaseTest;

import static com.epam.ex2.PageObjects.WebPageObject.*;
import static org.testng.AssertJUnit.assertTrue;

public class webMobileTests extends BaseTest {

    @Parameters({"searchData"})
    @Test(groups = {"web"}, description = "Make sure that we've get valid search results")
    public void simpleWebTest(String searchData)
            throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        getDriver().get("http://www.google.com"); // open Google homepage

        enterSearchData(searchData);
        assertTrue(getResults().stream().anyMatch(str -> str.trim().contains(searchData)));

        // Log that test finished
        System.out.println("Search results were found");
    }
}
