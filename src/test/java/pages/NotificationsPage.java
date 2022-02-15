package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

@Log4j2
public class NotificationsPage extends BasePage {
    public static final By MY_JEFIT_SPAN = By.xpath("//span[text()='My Jefit']");
    public static final By NOTIFICATIONS_SPAN = By.xpath("//span[text()='Notifications']");
    public static final By NOTIFICATIONS_TITLE = By.xpath("//b[text()='Notifications']");

    public NotificationsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Find element to make sure the page is open")
    public boolean isPageOpen() {
        log.info("Find element --> " + NOTIFICATIONS_TITLE);
        return isExist(NOTIFICATIONS_TITLE);
    }

    @Step("Open notifications")
    public NotificationsPage openNotifications() {
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(MY_JEFIT_SPAN);
        action.moveToElement(we).moveToElement(driver.findElement(NOTIFICATIONS_SPAN)).click().build().perform();
        return this;
    }


}