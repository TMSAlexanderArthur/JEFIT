package pages;

import elements.HrefButton;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.NotificationsPage.MY_JEFIT_SPAN;
import static pages.SettingsProfileAppPage.SETTINGS_SPAN;

@Log4j2
public class SettingsEmailPasswordPage extends BasePage {
    public static final By CURRENT_PASSWORD_INPUT = By.xpath("//input[@id='currentpassword']");
    public static final By EMAIL_PASSWORD_PAGE_TITLE = By.xpath("//h2[text()='Verify your Identity (Required)']");

    public SettingsEmailPasswordPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Find element to make sure the page is open")
    public boolean isPageOpen() {
        log.info("Find element --> " + CURRENT_PASSWORD_INPUT);
        return isExist(CURRENT_PASSWORD_INPUT);
    }

    @Step("Open Email Password Settings")
    public SettingsEmailPasswordPage openEmailPasswordSettings() {
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(MY_JEFIT_SPAN);
        action.moveToElement(we).moveToElement(driver.findElement(SETTINGS_SPAN)).click().build().perform();
        new HrefButton(driver, "Email / Password").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL_PASSWORD_PAGE_TITLE));
        return new SettingsEmailPasswordPage(driver);
    }


}
