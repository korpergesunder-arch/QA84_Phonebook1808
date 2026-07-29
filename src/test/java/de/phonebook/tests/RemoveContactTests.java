package de.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {
    @BeforeMethod
    public void precondition(){
        clickOnLoginLink();
        fillLoginRegisterForm("stupachenko30@gmail.com", "QWERTy123!");
        clickOnLoginButton();

        clickOnAddLink();

        fillAddContactForm("Oliver", "Kan", "12345678458", "kan@gmail.com", "TelAviv", "QA");
        clickOnSaveButton();
    }
    @Test
    public void removeContactTest(){
        int sizeBefore =sizeOfContacts();
        RemoveContact();
        pause(1000);
        int sizeAfter = sizeOfContacts();
        Assert.assertEquals(sizeAfter,sizeBefore -1);
    }

}
