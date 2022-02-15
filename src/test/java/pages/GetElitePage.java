package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class GetElitePage extends BasePage {
    public static final By GET_ELITE_MAIN_BUTTON = By.xpath("//span[@class='raven-button-text']");
    public static final By GET_ELITE_BUTTON = By.xpath("//a[@class='btn btn-primary px-5 py-3']");

    public GetElitePage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Find element to make sure the page is open")
    public boolean isPageOpen() {
        log.info("Find element --> " + GET_ELITE_BUTTON);
        return isExist(GET_ELITE_BUTTON);
    }

    @Step("Open Get elite page")
    public GetElitePage openGetElitePage() {
        driver.findElement(GET_ELITE_MAIN_BUTTON).click();
        log.info("Click on Get Elite Main Button by " + GET_ELITE_MAIN_BUTTON);
        return this;
    }
}
