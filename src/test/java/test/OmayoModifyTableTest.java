package test;

import Configuration.WebDriverFactory;
import Configuration.WebDriverHelper;
import PageObjects.OmayoPageObjects;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

public class OmayoModifyTableTest extends WebDriverHelper {

    WebDriver driver = null;
    WebDriverFactory webDriverFactory = new WebDriverFactory();

    OmayoPageObjects omayoPageObjects = new OmayoPageObjects();

    @BeforeTest
    public void setUp() {
        driver = webDriverFactory.createWebDriver("CHROME_WDM", "https://omayo.blogspot.com/");
        windowsHandle.put("main", driver.getWindowHandle());
    }



    @Test
    public void modifyAttributeTest(){
        //WEB ELEMENT
        WebElement table1Elem = getElement(driver, omayoPageObjects.table1xLoc);

        setAttribute(driver, omayoPageObjects.table1xLoc, "border", "50");

        setAttribute(driver, table1Elem, "border", "100");

    }

    @AfterTest
    public void tearDown() {
        driver.quit();

    }




}