package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class AllExerciseDatabasePage extends BasePage {
    public static final By ALL_EXERCISES_DATABASE_TITLE = By.xpath("//strong[@id='bodyparttext']");

    public AllExerciseDatabasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Find element to make sure the page is open")
    public boolean isPageOpen() {
        log.info("Find element --> " + ALL_EXERCISES_DATABASE_TITLE);
        return isExist(ALL_EXERCISES_DATABASE_TITLE);
    }


}
