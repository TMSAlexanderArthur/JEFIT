package pages;

import elements.HrefButton;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class WorkoutPlansPage extends BasePage {
    public static final By SEARCH_WORKOUT_PLANS_BUTTON = By.xpath("//input[@value='Search']");

    public WorkoutPlansPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Find element to make sure the page is open")
    public boolean isPageOpen() {
        log.info("Find element --> " + SEARCH_WORKOUT_PLANS_BUTTON);
        return isExist(SEARCH_WORKOUT_PLANS_BUTTON);
    }

    @Step("Open Workout plans")
    public WorkoutPlansPage openWorkoutPlans() {
        new HrefButton(driver, "Workout Plans").click();
        return this;
    }

}
