package pages;

import elements.HrefButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExercisesPage extends BasePage {
    public static final By EXERCISES_BY_BODY_PART_TITLE = By.xpath("//strong[@id='exercisedatabasetext']");
    public static final By VIEW_ALL_EXERCISES_BUTTON = By.xpath("(//a[@class='exerciseblueButton'])[7]");

    public ExercisesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(EXERCISES_BY_BODY_PART_TITLE);
    }

    public ExercisesPage openExercisePage() {
        new HrefButton(driver, "Exercises").click();
        return this;
    }

    public AllExerciseDatabasePage openAllExerciseDatabase() {
        driver.findElement(VIEW_ALL_EXERCISES_BUTTON).click();
        return new AllExerciseDatabasePage(driver);
    }

}
