package test;

import Configuration.WebDriverFactory;
import Configuration.WebDriverHelper;
import PageObjects.ActionChainsPageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ActionChains2Test extends WebDriverHelper {

    WebDriver driver = null;

    WebDriverFactory webDriverFactory = new WebDriverFactory();

    ActionChainsPageObjects actionChainsPageObjects = new ActionChainsPageObjects();


    @BeforeTest
    public void setUp() {
        driver = webDriverFactory.createWebDriver("CHROME", "https://www.geeksforgeeks.org/action-chains-in-selenium-python/");

    }

    /*
        Action seriesOfActions = builder
                .moveToElement(txtUsername)
                .click()
                .keyDown(txtUsername, Keys.SHIFT)
                .sendKeys(txtUsername, "hello")
                .keyUp(txtUsername, Keys.SHIFT)
                .doubleClick(txtUsername)
                .contextClick()
                .build();
        seriesOfActions.perform();

        
        Alternativa.
        //driver.navigate().to("https://testpages.eviltester.com/styled/redirector.html?to=/csspseudo/css-hover.html");
        */
    @Test
    public void Action1Test(){

        //build actions
        Action seriesOfActions = moveToElement(driver, actionChainsPageObjects.menuWebTechLoc);
        seriesOfActions.perform();

        Action seriesOfActions2 = moveToElementAndClick(driver, actionChainsPageObjects.htmlTutorialLoc);
        seriesOfActions2.perform();


    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
