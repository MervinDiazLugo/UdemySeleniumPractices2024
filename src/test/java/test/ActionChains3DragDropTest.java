package test;

import Configuration.WebDriverFactory;
import Configuration.WebDriverHelper;
import PageObjects.ActionChainsPageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ActionChains3DragDropTest extends WebDriverHelper {

    WebDriver driver = null;

    WebDriverFactory webDriverFactory = new WebDriverFactory();

    ActionChainsPageObjects actionChainsPageObjects = new ActionChainsPageObjects();


    @BeforeTest
    public void setUp() {
        driver = webDriverFactory.createWebDriver("CHROME",
                "https://testpages.eviltester.com/styled/drag-drop-javascript.html");

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
        Action seriesOfActions = dragAndDropToElement(driver,
                actionChainsPageObjects.draggable2Loc, actionChainsPageObjects.droppable1Loc);

        seriesOfActions.perform();


    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
