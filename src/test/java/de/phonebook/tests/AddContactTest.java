package de.phonebook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddContactTest extends TestBase{

    @BeforeMethod
    public void precondition(){
//before -login
        click(By.cssSelector("[href='/login']"));
        type(By.name("email"), "stupachenko30@gmail.com");
        type(By.name("password"), "QWERTy123!");
        click(By.name("login"));

    }
//click on add link
@Test
    public void addContactPositiveTest(){
        click(By.cssSelector("[href='/add']"));

        type(By.xpath("//input[1]"), "Oliver");
        type(By.xpath("//input[2]"), "Kan");
        type(By.xpath("//input[3]"), "12345678458");
        type(By.xpath("//input[4]"), "kan@gmail.com");
        type(By.xpath("//input[5]"), "TelAviv");
        type(By.xpath("//input[6]"), "QA");
click(By.cssSelector(".add_form__2rsm2 button"));
    Assert.assertTrue(verifyByName("Oliver"));
}

    public boolean verifyByName(String text) {
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        for (WebElement element: contacts){
            if (element.getText().contains(text))
                return true;
        }
        return false;
    }

       @AfterMethod
    public void postCondition(){
           //click on card
           click(By.cssSelector(".contact-item_card__2SOIM"));
//click on Remove button
           click(By.xpath("//button[.='Remove']"));

    }
//enter name
//enter lastname
//enter phone
//enter email
//enter address
//enter description
//click on Save button
}
