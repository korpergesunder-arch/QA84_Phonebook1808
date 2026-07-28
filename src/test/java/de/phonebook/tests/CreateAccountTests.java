package de.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void newUserRegisterPositiveTest(){
        click(By.cssSelector("[href='/login']"));
        type(By.name("email"), "stupachenko30@gmail.com");
        type(By.name("password"), "QWERTy123!");
        click(By.name("registration"));
        Assert.assertTrue(isElementPresent(By.xpath("//*[.='Sign Out']")));

    }


    @Test
    public void existedUserRegisterNegativeTest(){

        click(By.cssSelector("[href='/login']"));
        type(By.name("email"), "stupachenko30@gmail.com");
        type(By.name("password"), "QWERTy123!");
        click(By.name("registration"));
        Assert.assertTrue(isAlertPresent());

    }

}
