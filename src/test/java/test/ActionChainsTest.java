package test;

import Configuration.WebDriverFactory;
import Configuration.WebDriverHelper;
import PageObjects.ActionChainsPageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//ACTION CHAINS
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionChainsTest extends WebDriverHelper {

    WebDriver driver = null;

    WebDriverFactory webDriverFactory = new WebDriverFactory();

    ActionChainsPageObjects actionChainsPageObjects = new ActionChainsPageObjects();


    @BeforeTest
    public void setUp() {
        driver = webDriverFactory.createWebDriver("CHROME", "https://testpages.eviltester.com/styled/csspseudo/css-hover.html");

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

        Actions builder = new Actions(driver);

        //build actions
        Action seriesOfActions = builder
                .moveToElement(getElement(driver, actionChainsPageObjects.hoverDivParaLoc))
                .build();
        //Ejecutar acciones
        seriesOfActions.perform();


        Action seriesOfActions2 = builder
                .click(getElement(driver, actionChainsPageObjects.hoverLinkLoc))
                .build();
        seriesOfActions2.perform();




    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
