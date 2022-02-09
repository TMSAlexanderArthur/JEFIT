package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GetElitePage extends BasePage {
    public static final By GET_ELITE_MAIN_BUTTON = By.xpath("//span[@class='raven-button-text']");
    public static final By GET_ELITE_BUTTON = By.xpath("//a[@class='btn btn-primary px-5 py-3']");

    public GetElitePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(GET_ELITE_BUTTON);
    }

    public GetElitePage openGetElitePage() {
        driver.findElement(GET_ELITE_MAIN_BUTTON).click();
        return new GetElitePage(driver);
    }
}
