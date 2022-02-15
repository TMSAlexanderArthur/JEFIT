package pages;

import elements.HrefButton;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ExercisesPage extends BasePage {
    public static final By EXERCISES_BY_BODY_PART_TITLE = By.xpath("//strong[@id='exercisedatabasetext']");
    public static final By VIEW_ALL_EXERCISES_BUTTON = By.xpath("(//a[@class='exerciseblueButton'])[7]");

    public ExercisesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Find element to make sure the page is open")
    public boolean isPageOpen() {
        log.info("Find element --> " + EXERCISES_BY_BODY_PART_TITLE);
        return isExist(EXERCISES_BY_BODY_PART_TITLE);
    }

    @Step("Open Exercise Page")
    public ExercisesPage openExercisePage() {
        new HrefButton(driver, "Exercises").click();
        return this;
    }

    @Step("Open All Exercise Database")
    public AllExerciseDatabasePage openAllExerciseDatabase() {
        driver.findElement(VIEW_ALL_EXERCISES_BUTTON).click();
        log.info("Click view all exercise button");
        return new AllExerciseDatabasePage(driver);
    }

}
