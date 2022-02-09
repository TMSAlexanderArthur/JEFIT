package pages;

import elements.HrefButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CoachModePage extends BasePage {
    public static final By COACH_LOGO = By.xpath("//img[@width='800']");

    public CoachModePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(COACH_LOGO);
    }

    public CoachModePage openCoachModePage() {
        new HrefButton(driver, "Coach Mode").click();
        return new CoachModePage(driver);
    }

}
