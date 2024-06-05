package test;

import Configuration.WebDriverFactory;
import Configuration.WebDriverHelper;
import PageObjects.OmayoPageObjects;
import Pages.OmayoPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OmayoFramesTest extends WebDriverHelper {

    WebDriver driver = null;

    WebDriverFactory webDriverFactory = new WebDriverFactory();

    OmayoPageObjects omayoPageObjects = new OmayoPageObjects();

    OmayoPage omayoPage = new OmayoPage();

    @BeforeTest
    public void setUp(){
        driver = webDriverFactory.createWebDriver("CHROME", "https://omayo.blogspot.com/");

    }

    @Test
    public void frames1Test(){

        omayoPage.switchAndPrintTextMenu(driver);
        driver.switchTo().parentFrame();
        omayoPage.clickAlertAccept(driver);
        omayoPage.switchAndPrintMenuFrame2( driver);
        driver.switchTo().defaultContent();
        omayoPage.clickAlertAccept(driver);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
