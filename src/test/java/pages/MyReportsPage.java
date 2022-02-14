package pages;

import elements.HrefButton;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class MyReportsPage extends BasePage {

    public final By TRAINING_BREAKDOWN = By.xpath("//h2[@class = 'heading-md' and text()='Training Breakdown ']");
    public final By BARBELL_SQUAT_TEXT = By.xpath("//a[text()='Barbell Squat Images']");
    public final By NECK_TEXT = By.xpath("//strong[text() = 'Body stat progress: neck( inches):']");


    @Override
    public boolean isPageOpen() {
        return isExist(TRAINING_BREAKDOWN);
    }

    public MyReportsPage(WebDriver driver) {
        super(driver);
    }

    public MyReportsPage overallReportsOpen() {
        driver.get(BASE_URL + "/my-jefit/training-reports/index.php");
        log.info("Open overall reports");
        return this;
    }

    public boolean overallReportsIsOpened() {
        log.info("Text \"Training Breakdown \" found on page");
        return driver.findElement(TRAINING_BREAKDOWN).isDisplayed();
    }

    public MyReportsPage exerciseProgressOpen() {
        driver.get(BASE_URL + "/my-jefit/training-reports/exercise-progress.php");
        log.info("Open exercise progress");
        return this;
    }

    public String barbellSquatIsOpened() {
        new HrefButton(driver, "Barbell Squat").click();
        log.info("Text \"Barbell Squat Images\" found on page");
        return driver.findElement(BARBELL_SQUAT_TEXT).getText();
    }

    public MyReportsPage bodyProgressOpen() {
        driver.get(BASE_URL + "/my-jefit/training-reports/body-progress.php");
        log.info("Open body progress");
        return this;
    }

    public String neckInBodyProgressIsOpened() {
        new HrefButton(driver, "Neck").click();
        log.info("Text \"Body stat progress: neck( inches):\" found on page");
        return driver.findElement(NECK_TEXT).getText();
    }

    public MyReportsPage compareBodyOpen() {
        driver.get(BASE_URL + "/my-jefit/training-reports/compare.php");
        log.info("Open compare body");
        return this;
    }

    public String compareBodyIsOpened() {
        log.info("Return compare body URL");
        return driver.getCurrentUrl().trim();
    }


}
