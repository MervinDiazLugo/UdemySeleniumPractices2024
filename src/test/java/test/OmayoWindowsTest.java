package test;

import Configuration.WebDriverFactory;
import Configuration.WebDriverHelper;
import PageObjects.OmayoPageObjects;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OmayoWindowsTest extends WebDriverHelper {

    WebDriver driver = null;

    WebDriverFactory webDriverFactory = new WebDriverFactory();

    OmayoPageObjects omayoPageObjects = new OmayoPageObjects();

    @BeforeTest
    public void setUp(){
        driver = webDriverFactory.createWebDriver("CHROME", "https://omayo.blogspot.com/");
        windowsHandle.put("Principal", driver.getWindowHandle());
    }

    @Test
    public void windowsTest(){

        WebElement seleniumTutorialElem = getElement(driver, omayoPageObjects.seleniumTutorialLinkLoc);
        WebElement newPopUpLocElem = getElement(driver, omayoPageObjects.newPopUpLoc);
        if(seleniumTutorialElem!=null){
            seleniumTutorialElem.click();
            getWindowsHandle(driver, "SeleniumTutorial");
        }

        getWindowsHandle(driver, "Principal");

        if(newPopUpLocElem != null){
            newPopUpLocElem.click();
            getWindowsHandle(driver, "newPopUp");
        }


        getWindowsHandle(driver, "principal");

        /*//Ventana Actual
        driver.getWindowHandle();

        //ventanas Abiertas
        driver.getWindowHandles();

        //Switch a la ventana
        driver.switchTo().window("CD381961290D9ED63C26168C8F1C357C");
        driver.getCurrentUrl();*/


    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
