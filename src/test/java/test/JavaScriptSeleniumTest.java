package test;

import Configuration.WebDriverFactory;
import Configuration.WebDriverHelper;
import PageObjects.ActionChainsPageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavaScriptSeleniumTest extends WebDriverHelper {

    WebDriver driver = null;

    WebDriverFactory webDriverFactory = new WebDriverFactory();

    ActionChainsPageObjects actionChainsPageObjects = new ActionChainsPageObjects();


    @BeforeTest
    public void setUp() {
        driver = webDriverFactory.createWebDriver("CHROME", "https://www.geeksforgeeks.org/");

    }

    @Test
    public void jsTest(){

        //getElement(driver, actionChainsPageObjects.djangoCourse).click();
        jsClick(driver, driver.findElement(actionChainsPageObjects.djangoCourseLoc));
        waitPageCompletelyLoaded(driver);
        scrollToElement(driver, actionChainsPageObjects.footerLoc);

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
