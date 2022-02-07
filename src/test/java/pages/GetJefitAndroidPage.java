package pages;

import elements.HrefButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

import static pages.GetJefitIOsAppPage.GET_JEFIT_APP_BUTTON;

public class GetJefitAndroidPage extends BasePage{
    public static final By GOOGLE_PLAY_APP_TITLE = By.xpath("//h1[@class='AHFaub']");

    public GetJefitAndroidPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(GOOGLE_PLAY_APP_TITLE);
    }

    public GetJefitAndroidPage getGooglePlayApp() {
        driver.findElement(GET_JEFIT_APP_BUTTON).click();
        new HrefButton(driver, "Android App").click();
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        return new GetJefitAndroidPage(driver);
    }



}
