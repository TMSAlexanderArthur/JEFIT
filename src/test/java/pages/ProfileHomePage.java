package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfileHomePage extends BasePage {

    public static final By PROFILE_PIC = By.id("leftProfilePicCell");

    public ProfileHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(PROFILE_PIC);
    }
}
