package com.epam.ex2.scenarios;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.epam.ex2.setup.BaseTest;

import static com.epam.ex2.PageObjects.LoginNativePageObject.*;
import static com.epam.ex2.PageObjects.RegistrationNativePageObject.registerNewUser;
import static com.epam.ex2.util.RandomData.*;
import static org.testng.AssertJUnit.assertEquals;

public class nativeMobileTests extends BaseTest {

    @Parameters({"descriptionPage"})
    @Test(groups = {"native"}, description = "This test register and sign in")
    public void simpleNativeTest(String descriptionPage)
            throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        goToRegistrationPage();
        registerNewUser(email, username, password);
        login(email, password);

        //assert that on BudgetActivity page
        assertEquals(getDescriptionOfPage(), descriptionPage);

        System.out.println("Native test done");
    }
}
