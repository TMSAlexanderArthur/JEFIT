package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class MyMessagesPage extends BasePage {
    public static final By MY_MESSAGES_TAB = By.xpath("//a/li[text()=' My Messages']");
    public static final By POST_BUTTON = By.xpath("//input[@value='Post']");

    public MyMessagesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Find element to make sure the page is open")
    public boolean isPageOpen() {
        log.info("Find element --> " + POST_BUTTON);
        return isExist(POST_BUTTON);
    }

    @Step("Open My Messages")
    public MyMessagesPage openMyMessages() {
        driver.findElement(MY_MESSAGES_TAB).click();
        log.info("Click on My Message Tab by " + MY_MESSAGES_TAB);
        return new MyMessagesPage(driver);
    }

}
