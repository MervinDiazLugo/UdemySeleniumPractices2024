package test;

import Configuration.WebDriverFactory;
import Configuration.WebDriverHelper;
import PageObjects.OmayoPageObjects;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class OmayoTest extends WebDriverHelper {

    WebDriver driver = null;
    WebDriverFactory webDriverFactory = new WebDriverFactory();

    OmayoPageObjects omayoPageObjects = new OmayoPageObjects();

    @BeforeTest
    public void setUp() {
        driver = webDriverFactory.createWebDriver("CHROME", "https://omayo.blogspot.com/");
        windowsHandle.put("main", driver.getWindowHandle());
    }


    @Test
    public void selenium1TextBoxTest() {


        WebElement txtFNameElem = getElement(driver, omayoPageObjects.txtFNameLoc);
        WebElement txtFIdElem = getElement(driver, omayoPageObjects.txtFIdLoc);
        WebElement txtFXpathElem = getElement(driver, omayoPageObjects.txtFXpathLoc);

        if(txtFNameElem!=null && txtFIdElem!=null && txtFXpathElem!=null){
            txtFNameElem.clear();
            txtFNameElem.sendKeys("Hola mundo 1");

            txtFIdElem.clear();
            txtFIdElem.sendKeys("Hola mundo 2");

            txtFXpathElem.clear();
            txtFXpathElem.sendKeys("Hola mundo 3");
        }else{
            throw new SkipException("Skipping the test case");
        }

    }

    @Test
    public void selenium2DropDowns() {

        //WEB ELEMENT
        WebElement dropElm = getElement(driver, omayoPageObjects.drop1Loc);
        Select dropdown = new Select(dropElm);


        WebElement multiselectElm = getElement(driver, omayoPageObjects.multiselect1Loc);
        Select multiselect = new Select(multiselectElm);

        try {
            //SELECT by visible text
            dropdown.selectByVisibleText("doc 1");

            //SELECT by value (ver en el DOM ej jkl = doc 3)
            dropdown.selectByValue("jkl");


            //MULTI SELECT by value
            multiselect.selectByValue("audix");
            multiselect.selectByValue("volvox");

            //MULTI SELECT by visible text
            multiselect.selectByVisibleText("Hyundai");

        } catch (NoSuchElementException | TimeoutException e) {
            dropdown.selectByIndex(0);
            multiselect.selectByIndex(0);
        }


    }

    @Test
    public void selenium3DropDowns() {

        //WEB ELEMENT
        WebElement dropElm = getElement(driver, omayoPageObjects.drop1Loc);
        Select dropdown = new Select(dropElm);

        WebElement multiselectElm = getElement(driver, omayoPageObjects.multiselect1Loc);
        Select multiselect = new Select(multiselectElm);


        List<WebElement> multiSelectListOpt = multiselect.getOptions();
        Optional<WebElement> matchingOption = multiSelectListOpt.stream()
                .filter(option -> option.getText().equals("Audi"))
                .findFirst();
        matchingOption.ifPresent(elm -> elm.click());

        List<WebElement> dropOpt = dropdown.getOptions();
        Optional<WebElement> dropMatchingOption = dropOpt.stream()
                .filter(option -> option.getText().equals("doc 4"))
                .findFirst();
        dropMatchingOption.ifPresent(elm -> elm.click());

    }

    @Test
    public void selenium4xpathTest(){
        //WEB ELEMENT
        List<WebElement> table1Elem = getElements(driver, omayoPageObjects.table1Loc);
        WebElement table1PuneElm = getElement(driver, omayoPageObjects.table1PuneLoc);
        WebElement btnSameNameLoginElem = getElement(driver, omayoPageObjects.btnSameNameLoginLoc);
        List<WebElement> btnSameNameElem = getElements(driver, omayoPageObjects.btnSameNameLoc);

        //Encontrar un texto dentro de un WebElement List
        for(WebElement elem : table1Elem){
            if(elem.getText().equals("Bangalore")){
                System.out.println(elem.getText());
                break;
            }
        }

        //get Text
        System.out.println(table1PuneElm.getText());

        //CLick on element
        btnSameNameLoginElem.click();

        //Encontrar un texto dentro de un WebElement List
        for(WebElement btn : btnSameNameElem){
            if(btn.getText().equals("Register")){
                btn.click();
                break;
            }
        }
    }


    @Test
    public void selenium5AlertPrompt1(){
        getElement(driver, omayoPageObjects.btnAlert1).click();
        Alert btnAlert1 = isAlertPresent(driver);

        if(btnAlert1 != null){
            System.out.println(btnAlert1.getText());
            btnAlert1.accept();
        }

        getElement(driver, omayoPageObjects.btnConfirm1).click();
        Alert btnConfirm1 = isAlertPresent(driver);
        if(btnConfirm1 != null){
            System.out.println(btnConfirm1.getText());
            btnConfirm1.dismiss();
        }

        getElement(driver, omayoPageObjects.btnPrompt1).click();
        Alert btnPrompt1 = isAlertPresent(driver);
        if(btnPrompt1 != null){
            System.out.println(btnPrompt1.getText());
            btnPrompt1.sendKeys("Hola Mundo");
            btnPrompt1.accept();
        }

    }

    @Test
    public void switchWindows(){
        WebElement seleniumTutorialElem = getElement(driver, omayoPageObjects.seleniumTutorialLinkLoc);

        if(seleniumTutorialElem != null){
            seleniumTutorialElem.click();

        }

        getWindowsHandle(driver, "selenium143");

        WebElement questionElem = getElement(driver, omayoPageObjects.questionLoc);
        if(seleniumTutorialElem != null){
            questionElem.click();

        }

        getWindowsHandle(driver, "main");

        //ver ventana actual
        driver.getWindowHandle();



        //Listado de ventana
        driver.getWindowHandles();
        //driver.switchTo().window(driver.getWindowHandles().toArray()[1])
        //driver.findElement(By.linkText("What is Selenium?")).click();



    }

    @AfterTest
    public void tearDown() {
        driver.quit();

    }




}