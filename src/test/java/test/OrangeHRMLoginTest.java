package test;

import Configuration.WebDriverFactory;
import Configuration.WebDriverHelper;
import PageObjects.OrangeHRMPageObjects;
import Pages.OrangeHRMPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OrangeHRMLoginTest extends WebDriverHelper {

    WebDriver driver = null;

    WebDriverFactory webDriverFactory = new WebDriverFactory();

    OrangeHRMPageObjects orangeHRMPageObjects = new OrangeHRMPageObjects();
    OrangeHRMPage orangeHRMPage = new OrangeHRMPage();

    @BeforeTest
    public void setUp(){
        driver = webDriverFactory.createWebDriver("CHROME_WDM", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }

    @Test
    public void seleniumLoginTest(){
        orangeHRMPage.login(driver, "Admin", "admin123");

        WebElement userBulletElm = getElement(driver, orangeHRMPageObjects.userBulletLoc);
        Assert.assertTrue(userBulletElm!=null, "El login fue incorrecto");


    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }


}
