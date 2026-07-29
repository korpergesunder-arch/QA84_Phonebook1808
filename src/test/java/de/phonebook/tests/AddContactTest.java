package de.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTest extends TestBase{

    @BeforeMethod
    public void precondition(){
//before -login
        clickOnLoginLink();
        fillLoginRegisterForm("stupachenko30@gmail.com", "QWERTy123!");
        clickOnLoginButton();

    }
//click on add link
@Test
    public void addContactPositiveTest(){
    clickOnAddLink();

    fillAddContactForm("Oliver", "Kan", "12345678458", "kan@gmail.com", "TelAviv", "QA");
    clickOnSaveButton();
    Assert.assertTrue(verifyByName("Oliver"));
}

    @AfterMethod
    public void postCondition(){
           //click on card
           RemoveContact();

       }

    //enter name
//enter lastname
//enter phone
//enter email
//enter address
//enter description
//click on Save button
}
