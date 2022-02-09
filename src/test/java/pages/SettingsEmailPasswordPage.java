package pages;

import elements.HrefButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static pages.NotificationsPage.MY_JEFIT_SPAN;
import static pages.SettingsProfileAppPage.SETTINGS_SPAN;

public class SettingsEmailPasswordPage extends BasePage {
    public static final By CURRENT_PASSWORD_INPUT = By.xpath("//input[@id='currentpassword']");

    public SettingsEmailPasswordPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(CURRENT_PASSWORD_INPUT);
    }

    public SettingsEmailPasswordPage openEmailPasswordSettings() {
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(MY_JEFIT_SPAN);
        action.moveToElement(we).moveToElement(driver.findElement(SETTINGS_SPAN)).click().build().perform();
        new HrefButton(driver, "Email / Password").click();
        return new SettingsEmailPasswordPage(driver);
    }


}
