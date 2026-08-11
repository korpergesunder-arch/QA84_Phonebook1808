package de.phonebook.tests;

import de.phonebook.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {
    @BeforeMethod
    public void precondition(){
        if (!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();;
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new de.phonebook.model.User().setEmail("stupachenko30@gmail.com"). setPassword("QWERTy123!"));
        app.getUser().clickOnLoginButton();
        app.getContact().clickOnAddLink();
        app.getContact().fillAddContactForm(new de.phonebook.model.Contact()
                .setName("Oliver")
                .setLastName("Kan")
                .setPhone("12345678458")
                .setEmail("kan@gmail.com")
                .setAddress("TelAviv")
                .setDescription("QA"));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().verifyByName("Oliver"));
    }
    @Test
    public void removeContactTest(){
        int sizeBefore = app.getContact().sizeOfContacts();
        app.getContact().RemoveContact();
        app.getContact().pause(1000);
        int sizeAfter = app.getContact().sizeOfContacts();
        Assert.assertEquals(sizeAfter,sizeBefore -1);
    }

}
