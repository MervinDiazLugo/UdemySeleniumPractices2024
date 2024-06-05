package test;

import Configuration.WebDriverFactory;
import Configuration.WebDriverHelper;
import PageObjects.OrangeHRMPageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class OrangeHRMTest extends WebDriverHelper {

    WebDriver driver = null;
    WebDriverFactory webDriverFactory = new WebDriverFactory();
    OrangeHRMPageObjects orangeHRMPageObjects = new OrangeHRMPageObjects();

    @BeforeTest
    public void setUp(){
        driver = webDriverFactory.createWebDriver("CHROME_WDM", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test
    public void seleniumTest(){

        WebElement logoImgElm = getElement(driver, orangeHRMPageObjects.logoImgLoc);
        WebElement userNameElm = getElement(driver, orangeHRMPageObjects.userNameLoc);
        WebElement passwordElm = getElement(driver, orangeHRMPageObjects.passwordLoc);
        WebElement loginBtnElm= getElement(driver, orangeHRMPageObjects.loginBtnLoc);
        WebElement userNameElm2= getElement(driver, orangeHRMPageObjects.usernameLoc2);
        WebElement passwordElm2 = getElement(driver, orangeHRMPageObjects.passwordLoc2);

        Assert.assertTrue(userNameElm!=null, "El txt user Name no existe");
        Assert.assertTrue(passwordElm!=null, "El txt password Name no existe");
        Assert.assertTrue(loginBtnElm!=null, "El btn Login Name no existe");

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }


}
