package com.epam.ex2.scenarios;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.epam.ex2.setup.BaseTest;

import static com.epam.ex2.pageObjects.NativePageObject.*;

public class nativeMobileTests extends BaseTest {

    @Parameters({"email", "username", "password", "descriptionPage"})
    @Test(groups = {"native"}, description = "This simple test sign in")
    public void simpleNativeTest(String email, String username, String password, String decriptionPage)
            throws NoSuchFieldException, IllegalAccessException, InstantiationException{

        registerNewUser(email, username, password);
        login(email, password);

        new WebDriverWait(getDriver(), 10)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOf(getDescriptionOfPage()));

        //assert that on BudgetActivity page
        assert (getDescriptionOfPage().getText().equals(decriptionPage));

        System.out.println("Simplest Android native test done");
    }
}
