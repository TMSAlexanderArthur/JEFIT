package pages;

import elements.HrefButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WorkoutPlansPage extends BasePage {
    public static final By SEARCH_WORKOUT_PLANS_BUTTON = By.xpath("//input[@value='Search']");

    public WorkoutPlansPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(SEARCH_WORKOUT_PLANS_BUTTON);
    }

    public WorkoutPlansPage openWorkoutPlans() {
        new HrefButton(driver, "Workout Plans").click();
        return new WorkoutPlansPage(driver);
    }

}
