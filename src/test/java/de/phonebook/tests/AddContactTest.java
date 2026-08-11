package de.phonebook.tests;

import de.phonebook.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTest extends TestBase {

    @BeforeMethod
    public void precondition(){
        if (!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();;
        }
//before -login
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new de.phonebook.model.User().setEmail("stupachenko30@gmail.com"). setPassword("QWERTy123!"));
        app.getUser().clickOnLoginButton();

    }
//click on add link
@Test
    public void addContactPositiveTest(){
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

    @AfterMethod
    public void postCondition(){
           //click on card
           app.getContact().RemoveContact();

       }

    //enter name
//enter lastname
//enter phone
//enter email
//enter address
//enter description
//click on Save button
}
