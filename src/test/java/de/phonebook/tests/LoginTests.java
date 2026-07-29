package de.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginRegisteredUserPositiveTest(){
        clickOnLoginLink();
        fillLoginRegisterForm("stupachenko30@gmail.com", "QWERTy123!");
        clickOnLoginButton();
        Assert.assertTrue(isSignOutButtonPresent());

    }

}
