package pages;

import elements.HrefButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllExerciseDatabasePage extends BasePage {
    public static final By ALL_EXERCISES_DATABASE_TITLE = By.xpath("//strong[@id='bodyparttext']");

    public AllExerciseDatabasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(ALL_EXERCISES_DATABASE_TITLE);
    }


}
