package de.phonebook.tests;

import de.phonebook.pages.JavaScriptAlertsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class JavaScriptAlertsTests {

    private WebDriver driver;
    private JavaScriptAlertsPage alertsPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        alertsPage = new JavaScriptAlertsPage(driver);
    }

    @Test
    public void testJSAlert() {

        alertsPage.clickJSAlert();

        assertEquals(
                alertsPage.getAlertText(),
                "I am a JS Alert"
        );

        alertsPage.acceptAlert();

        assertEquals(
                alertsPage.getResultText(),
                "You successfully clicked an alert"
        );
    }

    @Test
    public void testJSConfirmAccept() {

        alertsPage.clickJSConfirm();

        assertEquals(
                alertsPage.getAlertText(),
                "I am a JS Confirm"
        );

        alertsPage.acceptAlert();

        assertEquals(
                alertsPage.getResultText(),
                "You clicked: Ok"
        );
    }

    @Test
    public void testJSConfirmCancel() {

        alertsPage.clickJSConfirm();

        assertEquals(
                alertsPage.getAlertText(),
                "I am a JS Confirm"
        );

        alertsPage.dismissAlert();

        assertEquals(
                alertsPage.getResultText(),
                "You clicked: Cancel"
        );
    }

    @Test
    public void testJSPrompt() {

        alertsPage.clickJSPrompt();

        assertEquals(
                alertsPage.getAlertText(),
                "I am a JS prompt"
        );

        alertsPage.sendKeysToAlert("Hello");

        alertsPage.acceptAlert();

        assertEquals(
                alertsPage.getResultText(),
                "You entered: Hello"
        );
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}