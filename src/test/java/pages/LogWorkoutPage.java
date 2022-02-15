package pages;

import com.github.javafaker.Faker;
import elements.HrefButton;
import elements.IdButton;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.BodyStats;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.ThreadLocalRandom;

@Log4j2
public class LogWorkoutPage extends BasePage {

    public static final By SESSION_SUMMARY_TITLE = By.xpath("//strong[text()='Session Summary']");
    public static final By LOG_WORKOUT_BUTTON = By.xpath("//a[normalize-space()='Log Workout']");
    public static final By CREATE_SUMMARY_BUTTON = By.xpath("//button[text()='Create Summary']");
    public static final By SUMMARY_IS_CREATED = By.xpath("//div[@class = 'col-12']/div[@class= 'workout-session']");
    public static final By WEIGHT_IS_OPENED = By.xpath("//strong[text()='Body stat progress: weight( lbs):']");
    public static final By TRAINING_IS_OPENED = By.xpath("//img[@title = 'Mark your favorite exercise. (Click again to undo)']");
    public static final By CREATE_NOTE_BUTTON = By.xpath("//button[text()='Create Note']");
    public static final By NOTE_TEXT = By.xpath("descendant::div[@class = 'fixed-note'][last()]");
    public static final By NOTE_TEXT_AREA = By.xpath("//div[@class = 'add-note-layout']/form/textarea");
    public static final By WEIGHT_BODY_STATS_BUTTON = By.xpath("//strong[text()=' Weight : ']/ancestor::a");

    Faker faker = new Faker();
    String text = faker.chuckNorris().fact();
    String bodyStatsFieldValue = "//strong[text()=' %s : ']/parent::a";

    @Override
    @Step("Find element to make sure the page is open")
    public boolean isPageOpen() {
        log.info("Find element --> " + SESSION_SUMMARY_TITLE);
        return isExist(SESSION_SUMMARY_TITLE);
    }

    public LogWorkoutPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Log Workout page")
    public LogWorkoutPage open() {
        driver.findElement(LOG_WORKOUT_BUTTON).click();
        log.info("Open Log Workout Page by " + LOG_WORKOUT_BUTTON);
        return this;
    }

    @Step("Get text by faker")
    public String returnNoteFakerText() {
        log.info("Return text : " + text);
        return text;
    }

    @Step("Get Note value")
    public String getNoteText() throws InterruptedException {
        Thread.sleep(3000);
        log.debug("Sleep 3 seconds");
        String[] value = driver.findElement(NOTE_TEXT).getText().split(":");
        log.info("Return " + value[1].trim());
        return value[1].trim();
    }

    @Step("Create Note")
    public LogWorkoutPage createNote() {
        driver.findElement(NOTE_TEXT_AREA).sendKeys(text);
        log.info("Write " + text + " into Note Text Area by " + NOTE_TEXT_AREA);
        driver.findElement(CREATE_NOTE_BUTTON).click();
        log.info("Click Create Note button by " + CREATE_NOTE_BUTTON);
        return this;
    }

    @Step("Delete body stats")
    public void deleteBodyStats() {
        new IdButton(driver, "delete-body-stats").click();
    }

    @Step("Click Add Body Stats Button")
    public LogWorkoutPage clickAddBodyStatsButton() {
        new IdButton(driver, "edit-body-stats").click();
        return this;
    }

    @Step("Click Add Session Summary button")
    public LogWorkoutPage clickAddSessionSummaryButton() {
        new IdButton(driver, "add-session").click();
        return this;
    }

    @Step("Click Notes Add button")
    public LogWorkoutPage clickNotesAddButton() {
        new IdButton(driver, "add-note").click();
        return this;
    }

    @Step("Make sure the Summary is created")
    public boolean summaryIsCreated() {
        log.info("Find element --> " + SUMMARY_IS_CREATED);
        return driver.findElement(SUMMARY_IS_CREATED).isDisplayed();
    }

    @Step("Create {bodyStats}")
    public LogWorkoutPage createBodyStats(BodyStats bodyStats) {
        new Input(driver, "weight").write(bodyStats.getWeight());
        new Input(driver, "fatpercent").write(bodyStats.getBodyFat());
        new Input(driver, "height").write(bodyStats.getHeight());
        new Input(driver, "chest").write(bodyStats.getChest());
        new Input(driver, "waist").write(bodyStats.getWaist());
        new Input(driver, "arms").write(bodyStats.getArms());
        new Input(driver, "shoulders").write(bodyStats.getShoulders());
        new Input(driver, "forearms").write(bodyStats.getForeams());
        new Input(driver, "neck").write(bodyStats.getNeck());
        new Input(driver, "hips").write(bodyStats.getHips());
        new Input(driver, "thighs").write(bodyStats.getThighs());
        new Input(driver, "calves").write(bodyStats.getCalves());
        log.info("Create " + bodyStats + "\n and click Done button  ");
        return clickDoneBodyStats();
    }

    @Step("Create Session Summary")
    public LogWorkoutPage createSessionSummary() {
        int randomHourStart = ThreadLocalRandom.current().nextInt(0, 24);
        int randomHourEnd = ThreadLocalRandom.current().nextInt(0, 24);
        int randomMinStart = ThreadLocalRandom.current().nextInt(0, 60);
        int randomMinEnd = ThreadLocalRandom.current().nextInt(0, 60);
        String hourStart = Integer.toString(randomHourStart);
        String hourEnd = Integer.toString(randomHourEnd);
        String minStart = Integer.toString(randomMinStart);
        String minEnd = Integer.toString(randomMinEnd);
        new Input(driver, "starthour").clear();
        new Input(driver, "starthour").write(hourStart);
        new Input(driver, "startmin").clear();
        new Input(driver, "startmin").write(minStart);
        new Input(driver, "endhour").clear();
        new Input(driver, "endhour").write(hourEnd);
        new Input(driver, "endmin").clear();
        new Input(driver, "endmin").write(minEnd);
        log.info("Create Session Summary with random data and click Create Summary button");
        return clickCreateSummaryButton();
    }

    @Step("Open Weight page")
    public LogWorkoutPage moveIntoAWeightBodyPart() {
        driver.findElement(WEIGHT_BODY_STATS_BUTTON).click();
        log.info("Click on WEIGHT element by " + WEIGHT_BODY_STATS_BUTTON);
        return this;
    }

    @Step("Make sure the weight is opened and back to the Log Workout Page")
    public boolean weightIsOpenedAndBackToTheLogWorkoutPage() {
        boolean weightIsOpened = driver.findElement(WEIGHT_IS_OPENED).isDisplayed();
        log.info("Text \"Body stat progress: weight( lbs):\" found on page");
        driver.navigate().back();
        log.info("Go back to the previous page");
        return weightIsOpened;
    }

    @Step("Get text at field {fieldName} ")
    public String getBodyStatsValue(String fieldName) {
        log.info("Return the text from the field - " + fieldName);
        return driver.findElement(By.xpath(String.format(bodyStatsFieldValue, fieldName))).getText().replaceAll("[^0-9]", "");
    }

    @Step("Click Create Summary button ")
    public LogWorkoutPage clickCreateSummaryButton() {
        driver.findElement(CREATE_SUMMARY_BUTTON).click();
        log.info("Click Create Summary button by " + CREATE_SUMMARY_BUTTON);
        return this;
    }

    @Step("Click Done Body Status Button")
    public LogWorkoutPage clickDoneBodyStats() {
        new IdButton(driver, "submit-body-stats").click();
        return this;
    }

    @Step("Move to Training Stats")
    public LogWorkoutPage moveToTrainingStats() {
        new HrefButton(driver, "Training Stats").click();
        new HrefButton(driver, "Barbell Bench Press").click();
        return this;
    }

    @Step("Make sure the Training is opened")
    public boolean trainingIsOpened() {
        log.info("Text \"Mark your favorite exercise. (Click again to undo)\" found on Training page");
        return driver.findElement(TRAINING_IS_OPENED).isDisplayed();
    }


}