package pages;

import elements.ButtonWithText;
import elements.HrefButton;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static pages.NotificationsPage.MY_JEFIT_SPAN;
import static pages.SettingsProfileAppPage.SETTINGS_SPAN;


@Log4j2
public class SettingsNotificationPrivacyPage extends BasePage {
    public static final By MANAGE_NOTIFICATIONS_TITLE = By.xpath("//h2[text()='Manage your Notifications.']");

    public static final By NOTIFICATIONS_OPTIONS = By.xpath("//input[@name='e-Freq']");
    public static final By NOTIFICATIONS_OPTION_CHECKED = By.xpath("//input[@name='e-Freq' and @checked]");

    public static final By PRIVACY_OPTIONS = By.xpath("//input[@name='p0']");
    public static final By PRIVACY_OPTION_CHECKED = By.xpath("//td[contains (@class,'click')]/p/input[@name='p0']");

    public static final By SAVE_NOTIFICATION_CHANGES = By.xpath("(//button[text()='Save Changes' and @type='submit'])[2]");
    public static final By SAVE_PRIVACY_CHANGES = By.xpath("//button[@alt='submit' and @value='Save']");

    public SettingsNotificationPrivacyPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(MANAGE_NOTIFICATIONS_TITLE);
    }

    public SettingsNotificationPrivacyPage openNotificationPrivacySettings() {
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(MY_JEFIT_SPAN);
        action.moveToElement(we).moveToElement(driver.findElement(SETTINGS_SPAN)).click().build().perform();
        new HrefButton(driver, "Notification / Privacy").click();
        return new SettingsNotificationPrivacyPage(driver);
    }

    public SettingsNotificationPrivacyPage editNotificationsReport() {
        List<WebElement> freqReport = driver.findElements(NOTIFICATIONS_OPTIONS);
        int reportTypeSize = freqReport.size();
        int randomReportType = ThreadLocalRandom.current().nextInt(0, reportTypeSize);
        freqReport.get(randomReportType).click();
        driver.findElement(SAVE_NOTIFICATION_CHANGES).click();
        new HrefButton(driver, "Notification / Privacy").click();
        return new SettingsNotificationPrivacyPage(driver);
    }

    public SettingsNotificationPrivacyPage editPrivacySettings() {
        List<WebElement> privacy = driver.findElements(PRIVACY_OPTIONS);
        int privacySize = privacy.size();
        int randomPrivacyType = ThreadLocalRandom.current().nextInt(0, privacySize);
        privacy.get(randomPrivacyType).click();
        WebElement saveButton = driver.findElement(SAVE_PRIVACY_CHANGES);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", saveButton);
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(MY_JEFIT_SPAN);
        action.moveToElement(we).moveToElement(driver.findElement(SETTINGS_SPAN)).click().build().perform();
        new HrefButton(driver, "Notification / Privacy").click();
        return new SettingsNotificationPrivacyPage(driver);
    }


}
