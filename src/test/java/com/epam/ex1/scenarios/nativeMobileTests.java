package com.epam.ex1.scenarios;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.epam.ex1.setup.BaseTest;
import static com.epam.ex1.PageObjects.NativePageObject.*;
import static org.testng.AssertJUnit.assertEquals;

public class nativeMobileTests extends BaseTest {

    @Parameters({"email", "username", "password", "descriptionPage"})
    @Test(groups = {"native"}, description = "This test register and sign in")
    public void simpleNativeTest(String email, String username, String password, String descriptionPage)
            throws NoSuchFieldException, IllegalAccessException, InstantiationException{

        registerNewUser(email, username, password);
        login(email, password);

        //assert that on BudgetActivity page
        assertEquals(getDescriptionOfPage(), descriptionPage);

        System.out.println("Android native test done");
    }
}
