package de.phonebook.tests;

import de.phonebook.core.TestBase;
import de.phonebook.model.Contact;
import de.phonebook.utils.MyDataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
@Test(dataProvider = "addNewContactFromCsv", dataProviderClass = MyDataProviders.class)
    public void addContactPositiveTest(Contact contact){
    app.getContact().clickOnAddLink();

    app.getContact().fillAddContactForm(contact);
    app.getContact().clickOnSaveButton();
    Assert.assertTrue(app.getContact().verifyByPhone(contact.getPhone()));

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
