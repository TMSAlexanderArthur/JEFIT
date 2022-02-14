package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static pages.NotificationsPage.MY_JEFIT_SPAN;

public class FriendsPage extends BasePage {
    public static final By FRIENDS_SPAN = By.xpath("//span[text()='Friends']");
    public static final By MY_FRIENDS_TITLE = By.xpath("//div[@id='friendsListTab']");

    public FriendsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(MY_FRIENDS_TITLE);
    }

    public FriendsPage openMyFriends() {
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(MY_JEFIT_SPAN);
        action.moveToElement(we).moveToElement(driver.findElement(FRIENDS_SPAN)).click().build().perform();
        return this;
    }


}
