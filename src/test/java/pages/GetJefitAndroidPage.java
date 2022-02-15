package pages;

import elements.HrefButton;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

import static pages.GetJefitIOsAppPage.GET_JEFIT_APP_BUTTON;

@Log4j2
public class GetJefitAndroidPage extends BasePage {
    public static final By GOOGLE_PLAY_APP_TITLE = By.xpath("//h1[@class='AHFaub']");

    public GetJefitAndroidPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Find element to make sure the page is open")
    public boolean isPageOpen() {
        log.info("Find element --> " + GOOGLE_PLAY_APP_TITLE);
        return isExist(GOOGLE_PLAY_APP_TITLE);
    }

    @Step("Go to tab Google Play App")
    public GetJefitAndroidPage getGooglePlayApp() {
        driver.findElement(GET_JEFIT_APP_BUTTON).click();
        log.info("Click button Get jefit app by " + GET_JEFIT_APP_BUTTON);
        new HrefButton(driver, "Android App").click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        log.info("Go to tab Google Play App");
        return this;
    }

}
