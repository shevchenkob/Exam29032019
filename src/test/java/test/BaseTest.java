package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.GooglePage;


public class BaseTest {
    WebDriver driver;
    GooglePage googlePage;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\shevchenko_b\\IdeaProjects\\qaauto-05.02.2019\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        googlePage = new GooglePage(driver);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}