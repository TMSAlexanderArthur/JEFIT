package pages;

import elements.HrefButton;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class BlogPage extends BasePage {
    public static final By SEARCH_TOPIC_INPUT = By.xpath("//input[@class='raven-search-form-input']");

    public BlogPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Find element to make sure the page is open")
    public boolean isPageOpen() {
        log.info("Find element --> " + SEARCH_TOPIC_INPUT);
        return isExist(SEARCH_TOPIC_INPUT);
    }
    @Step("Open blog page")
    public BlogPage openBlogPage() {
        new HrefButton(driver, "Blog").click();
        return this;
    }


}
