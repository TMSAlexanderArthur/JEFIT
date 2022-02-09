package pages;

import elements.HrefButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlogPage extends BasePage {
    public static final By SEARCH_TOPIC_INPUT = By.xpath("//input[@class='raven-search-form-input']");

    public BlogPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(SEARCH_TOPIC_INPUT);
    }

    public BlogPage openBlogPage() {
        new HrefButton(driver, "Blog").click();
        return new BlogPage(driver);
    }


}
