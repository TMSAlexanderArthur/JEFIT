package pages;

import elements.HrefButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyMessagesPage extends BasePage {
    public static final By MY_MESSAGES_TAB = By.xpath("//a/li[text()=' My Messages']");
    public static final By POST_BUTTON = By.xpath("//input[@value='Post']");

    public MyMessagesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(POST_BUTTON);
    }

    public MyMessagesPage openMyMessages() {
        driver.findElement(MY_MESSAGES_TAB).click();
        return new MyMessagesPage(driver);
    }

}
