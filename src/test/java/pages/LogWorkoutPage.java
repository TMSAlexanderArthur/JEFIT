package pages;

import elements.Input;
import models.BodyStats;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogWorkoutPage extends BasePage {

    public static final By SESSION_SUMMARY_TITLE = By.xpath("//strong[text()='Session Summary']");
    public static final By LOG_WORKOUT_BUTTON = By.xpath("//a[normalize-space()='Log Workout']");
    public static final By ADD_BODY_STATS_BUTTON = By.id("edit-body-stats");
    public static final By DELETE_BODY_STATS_BUTTON = By.id("delete-body-stats");
    public static final By DONE_BODY_STATS_BUTTON = By.id("submit-body-stats");
    String bodyStatsFieldValue = "//strong[text()=' %s : ']/parent::a";

    @Override
    public boolean isPageOpen() {
        return isExist(SESSION_SUMMARY_TITLE);
    }

    public LogWorkoutPage(WebDriver driver) {
        super(driver);
    }

    public LogWorkoutPage open() {
        driver.findElement(LOG_WORKOUT_BUTTON).click();
        return this;
    }

    public LogWorkoutPage deleteBodyStats(){
        try {
        driver.findElement(DELETE_BODY_STATS_BUTTON).click();}
        catch (org.openqa.selenium.StaleElementReferenceException ex){
            driver.findElement(DELETE_BODY_STATS_BUTTON).click();
        }
        return this;
    }

    public LogWorkoutPage clickAddBodyStatsButton() {
        driver.findElement(ADD_BODY_STATS_BUTTON).click();
        return this;
    }

    public LogWorkoutPage create(BodyStats bodyStats) {

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

        return clickDoneBodyStats();
    }

    public String getBodyStatsValue(String fieldName) {
        return  driver.findElement(By.xpath(String.format(bodyStatsFieldValue, fieldName))).getText().replaceAll("[^0-9]", "");
    }

    public LogWorkoutPage clickDoneBodyStats() {
        driver.findElement(DONE_BODY_STATS_BUTTON).click();
        return this;
    }


}
