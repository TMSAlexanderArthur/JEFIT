package pages;

import elements.HrefButton;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CoachModePage extends BasePage {
    public static final By COACH_LOGO = By.xpath("//img[@width='800']");

    public CoachModePage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Find element to make sure the page is open")
    public boolean isPageOpen() {
        log.info("Find element --> " + COACH_LOGO);
        return isExist(COACH_LOGO);
    }

    @Step("Open Coach mode page")
    public CoachModePage openCoachModePage() {
        new HrefButton(driver, "Coach Mode").click();
        return this;
    }

}
