package PageObjects;

import org.openqa.selenium.By;

public class OrangeHRMPageObjects {

    public By userNameLoc = By.name("username");
    public By passwordLoc =  By.name("password");
    public By loginBtnLoc = By.xpath("//button[@type='submit']");
    public By userBulletLoc = By.cssSelector("img[alt='profile picture']");

    public By logoImgLoc = By.cssSelector("img[src*='/web/images/ohrm_branding.png']");
    public By usernameLoc2 = By.name("username");
    public By passwordLoc2 =  By.name("password");

}
