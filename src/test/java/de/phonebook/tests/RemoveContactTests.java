package de.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {
    @BeforeMethod
    public void precondition(){
        click(By.cssSelector("[href='/login']"));
        type(By.name("email"), "stupachenko30@gmail.com");
        type(By.name("password"), "QWERTy123!");
        click(By.name("login"));

        click(By.cssSelector("[href='/add']"));

        type(By.xpath("//input[1]"), "Oliver");
        type(By.xpath("//input[2]"), "Kan");
        type(By.xpath("//input[3]"), "12345678458");
        type(By.xpath("//input[4]"), "kan@gmail.com");
        type(By.xpath("//input[5]"), "TelAviv");
        type(By.xpath("//input[6]"), "QA");
        click(By.cssSelector(".add_form__2rsm2 button"));
    }
    @Test
    public void removeContactTest(){
        int sizeBefore =sizeOfContacts();
        click(By.cssSelector(".contact-item_card__2SOIM"));
//click on Remove button
        click(By.xpath("//button[.='Remove']"));
        pause(1000);
        int sizeAfter = sizeOfContacts();
        Assert.assertEquals(sizeAfter,sizeBefore -1);
    }

    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int sizeOfContacts() {
        if(isElementPresent(By.cssSelector(".contact-item_card__2SOIM"))){
           return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();

        }
        return 0;
    }

}
