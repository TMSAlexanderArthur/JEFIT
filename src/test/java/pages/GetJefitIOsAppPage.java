package pages;

import elements.HrefButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class GetJefitIOsAppPage extends BasePage {
    public static final By GET_JEFIT_APP_BUTTON = By.xpath("//li[@id='get-jefit-app-menu']");
    public static final By APPLE_STORE_APP_TITLE = By.xpath("//h1[@class='product-header__title app-header__title']");

    public GetJefitIOsAppPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(APPLE_STORE_APP_TITLE);
    }

    public GetJefitIOsAppPage getAppleStoreApp() {
        driver.findElement(GET_JEFIT_APP_BUTTON).click();
        new HrefButton(driver, "iOS App").click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        return new GetJefitIOsAppPage(driver);
    }

}
