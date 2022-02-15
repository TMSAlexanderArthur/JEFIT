package pages;

import elements.HrefButton;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

@Log4j2
public class GetJefitIOsAppPage extends BasePage {
    public static final By GET_JEFIT_APP_BUTTON = By.xpath("//li[@id='get-jefit-app-menu']");
    public static final By APPLE_STORE_APP_TITLE = By.xpath("//h1[@class='product-header__title app-header__title']");

    public GetJefitIOsAppPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Find element to make sure the page is open")
    public boolean isPageOpen() {
        log.info("Find element --> " + APPLE_STORE_APP_TITLE);
        return isExist(APPLE_STORE_APP_TITLE);
    }

    @Step("Go to tab Aplle Store App")
    public GetJefitIOsAppPage getAppleStoreApp() {
        driver.findElement(GET_JEFIT_APP_BUTTON).click();
        log.info("Click button Get jefit app by " + GET_JEFIT_APP_BUTTON);
        new HrefButton(driver, "iOS App").click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        log.info("Go to tab Apple Store App");
        return this;
    }

}
