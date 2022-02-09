package pages;

import elements.HrefButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static pages.NotificationsPage.MY_JEFIT_SPAN;
import static pages.SettingsProfileAppPage.SETTINGS_SPAN;

public class SettingsMembershipPage extends BasePage{
    public static final By ACCOUNT_TYPE = By.xpath("//div[@style='font-size: 18px;']");

    public SettingsMembershipPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(ACCOUNT_TYPE);
    }

    public SettingsMembershipPage openMembershipSettings() {
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(MY_JEFIT_SPAN);
        action.moveToElement(we).moveToElement(driver.findElement(SETTINGS_SPAN)).click().build().perform();
        new HrefButton(driver, "Membership Settings").click();
        return new SettingsMembershipPage(driver);
    }

    public String getAccountType() {
        return driver.findElement(ACCOUNT_TYPE).getText();
    }

}
