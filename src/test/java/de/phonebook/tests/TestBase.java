package de.phonebook.tests;

import de.phonebook.core.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {


    protected static ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp () {
        app.init();
    }

    @AfterMethod(enabled = false)  //не закрывает браузер
    public void tearDown(){
        app.stop();
    }

}
