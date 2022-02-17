package pages;

import elements.HrefButton;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.NotificationsPage.MY_JEFIT_SPAN;
import static pages.SettingsProfileAppPage.SETTINGS_SPAN;

@Log4j2
public class SettingsMembershipPage extends BasePage {
    public static final By ACCOUNT_TYPE = By.xpath("//div[@style='font-size: 18px;']");
    public static final By MEMBERSHIP_PAGE_TITLE = By.xpath("//h2[text()='Manage your membership']");

    public SettingsMembershipPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Find element to make sure the page is open")
    public boolean isPageOpen() {
        log.info("Find element --> " + ACCOUNT_TYPE);
        return isExist(ACCOUNT_TYPE);
    }

    @Step("Open Membership settings")
    public SettingsMembershipPage openMembershipSettings() {
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(MY_JEFIT_SPAN);
        action.moveToElement(we).moveToElement(driver.findElement(SETTINGS_SPAN)).click().build().perform();
        new HrefButton(driver, "Membership Settings").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MEMBERSHIP_PAGE_TITLE));
        return new SettingsMembershipPage(driver);
    }

    @Step("Get account type")
    public String getAccountType() {
        log.info("Get text from " + ACCOUNT_TYPE);
        return driver.findElement(ACCOUNT_TYPE).getText();
    }

}
