package de.phonebook.tests;

import de.phonebook.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();;
        }
    }

    @Test
    public void loginRegisteredUserPositiveTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new de.phonebook.model.User().setEmail("stupachenko30@gmail.com"). setPassword("QWERTy123!"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
    }

        @Test
    public void loginRegisteredUserWithoutEmailNegativeTest(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new de.phonebook.model.User().setEmail("").setPassword("QWERTy123!"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertPresent());

    }


}
