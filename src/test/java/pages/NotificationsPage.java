package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class NotificationsPage extends BasePage {
    public static final By MY_JEFIT_SPAN = By.xpath("//span[text()='My Jefit']");
    public static final By NOTIFICATIONS_SPAN = By.xpath("//span[text()='Notifications']");
    public static final By NOTIFICATIONS_TITLE = By.xpath("//b[text()='Notifications']");

    public NotificationsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(NOTIFICATIONS_TITLE);
    }

    public NotificationsPage openNotifications() {
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(MY_JEFIT_SPAN);
        action.moveToElement(we).moveToElement(driver.findElement(NOTIFICATIONS_SPAN)).click().build().perform();
        return this;
    }


}
