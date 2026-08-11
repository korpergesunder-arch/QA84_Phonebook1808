package de.phonebook.tests;

import de.phonebook.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition(){
        app.getContact().pause(1000);
        if (!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();;
        }
    }



    @Test(enabled = false)
    public void newUserRegisterPositiveTest(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new de.phonebook.model.User().setEmail("stupachenko30@gmail.com"). setPassword("QWERTy123!"));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
    }

    @Test
    public void existedUserRegisterNegativeTest(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new de.phonebook.model.User().setEmail("stupachenko30@gmail.com"). setPassword("QWERTy123!"));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isAlertPresent());

    }

}
