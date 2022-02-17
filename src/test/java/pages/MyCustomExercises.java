package pages;

import elements.Input;
import elements.SelectDropdown;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.CustomExercise;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Log4j2
public class MyCustomExercises extends BasePage {
    public static final By MY_CUSTOM_EXERCISES_TAB = By.xpath("//a/li[text()=' My Custom Exercises']");
    public static final By CREATE_CUSTOMER_EXERCISE_TITLE = By.xpath("//th[@class='listheader']");
    public static final By CREATED_EXERCISE_NAME = By.xpath("//td[@align='left']");
    public static final By EDIT_BUTTON = By.xpath("//a[contains(@href, 'action=edit')]");
    public static final By EDIT_MAIN_BUTTON = By.xpath("//a[@class='statusblueButton']");
    public static final By DELETE_BUTTON = By.xpath("//a[@onclick='deleteExercise(100000)']");
    public static final By EMPTY_EXERCISE_LIST = By.xpath("//td[@colspan='4']");

    public static final By MAJOR_MUSCLE_GROUP_OPTIONS = By.xpath("//select[@name='selectpart']/option[@value>=0]");
    public static final By RECORD_TYPE_OPTIONS = By.xpath("//select[@name='select_recordtype']/option");
    public static final By OTHER_MUSCLE_GROUPS_1_OPTIONS = By.xpath("//select[@name='optpart1']/option[@value<=10]");
    public static final By OTHER_MUSCLE_GROUPS_2_OPTIONS = By.xpath("//select[@name='optpart2']/option[@value<=10]");

    public MyCustomExercises(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Find element to make sure the page is open")
    public boolean isPageOpen() {
        log.info("Find element --> " + CREATE_CUSTOMER_EXERCISE_TITLE);
        return isExist(CREATE_CUSTOMER_EXERCISE_TITLE);
    }

    @Step("Open My Custom Exercises")
    public MyCustomExercises openMyCustomExercises() {
        driver.findElement(MY_CUSTOM_EXERCISES_TAB).click();
        log.info("Click on My Custom Exercise tab by " + MY_CUSTOM_EXERCISES_TAB);
        return new MyCustomExercises(driver);
    }

    @Step("Create {customExercise}")
    public MyCustomExercises createNewCustomExercise(CustomExercise customExercise) {
        new Input(driver, "newename").write(customExercise.getExerciseName());

        SelectDropdown majorMuscleGroup = new SelectDropdown(driver, "selectpart");
        majorMuscleGroup.click();
        List<WebElement> optionsInDropdown1 = driver.findElements(MAJOR_MUSCLE_GROUP_OPTIONS);
        int typeGroup1 = optionsInDropdown1.size();
        int randomType1 = ThreadLocalRandom.current().nextInt(0, typeGroup1);
        optionsInDropdown1.get(randomType1).click();

        SelectDropdown recordType = new SelectDropdown(driver, "select_recordtype");
        recordType.click();
        List<WebElement> optionsInDropdown2 = driver.findElements(RECORD_TYPE_OPTIONS);
        int typeGroup2 = optionsInDropdown2.size();
        int randomType2 = ThreadLocalRandom.current().nextInt(0, typeGroup2);
        optionsInDropdown2.get(randomType2).click();

        SelectDropdown otherMuscleGroups1 = new SelectDropdown(driver, "optpart1");
        otherMuscleGroups1.click();
        List<WebElement> optionsInDropdown3 = driver.findElements(OTHER_MUSCLE_GROUPS_1_OPTIONS);
        int typeGroup3 = optionsInDropdown3.size();
        int randomType3 = ThreadLocalRandom.current().nextInt(0, typeGroup3);
        optionsInDropdown3.get(randomType3).click();

        SelectDropdown otherMuscleGroups2 = new SelectDropdown(driver, "optpart2");
        otherMuscleGroups2.click();
        List<WebElement> optionsInDropdown4 = driver.findElements(OTHER_MUSCLE_GROUPS_2_OPTIONS);
        int typeGroup4 = optionsInDropdown4.size();
        int randomType4 = ThreadLocalRandom.current().nextInt(0, typeGroup4);
        optionsInDropdown3.get(randomType4).click();

        return clickSave();
    }

    @Step("Edit {customExercise}")
    public MyCustomExercises editCustomExercise(CustomExercise customExercise) {
        new Input(driver, "newename").clear();
        new Input(driver, "newename").write(customExercise.getExerciseName());

        SelectDropdown majorMuscleGroup = new SelectDropdown(driver, "selectpart");
        majorMuscleGroup.click();
        List<WebElement> optionsInDropdown1 = driver.findElements(MAJOR_MUSCLE_GROUP_OPTIONS);
        int typeGroup1 = optionsInDropdown1.size();
        int randomType1 = ThreadLocalRandom.current().nextInt(0, typeGroup1);
        optionsInDropdown1.get(randomType1).click();

        SelectDropdown recordType = new SelectDropdown(driver, "select_recordtype");
        recordType.click();
        List<WebElement> optionsInDropdown2 = driver.findElements(RECORD_TYPE_OPTIONS);
        int typeGroup2 = optionsInDropdown2.size();
        int randomType2 = ThreadLocalRandom.current().nextInt(0, typeGroup2);
        optionsInDropdown2.get(randomType2).click();

        SelectDropdown otherMuscleGroups1 = new SelectDropdown(driver, "optpart1");
        otherMuscleGroups1.click();
        List<WebElement> optionsInDropdown3 = driver.findElements(OTHER_MUSCLE_GROUPS_1_OPTIONS);
        int typeGroup3 = optionsInDropdown3.size();
        int randomType3 = ThreadLocalRandom.current().nextInt(0, typeGroup3);
        optionsInDropdown3.get(randomType3).click();

        SelectDropdown otherMuscleGroups2 = new SelectDropdown(driver, "optpart2");
        otherMuscleGroups2.click();
        List<WebElement> optionsInDropdown4 = driver.findElements(OTHER_MUSCLE_GROUPS_2_OPTIONS);
        int typeGroup4 = optionsInDropdown4.size();
        int randomType4 = ThreadLocalRandom.current().nextInt(0, typeGroup4);
        optionsInDropdown3.get(randomType4).click();

        return clickSave();
    }

    @Step("Click Save button")
    public MyCustomExercises clickSave() {
        log.info("Click on the save new exercise button");
        new Input(driver, "Submit").click();
        return new MyCustomExercises(driver);
    }

    @Step("Get created Exercise name")
    public String getCreatedExerciseName() {
        log.info("Get create exercise name by " + CREATED_EXERCISE_NAME);
        return driver.findElement(CREATED_EXERCISE_NAME).getText();
    }

    @Step("Get cempty exercise list")
    public String getEmptyExercisesList() {
        log.info("Get empty exercises list by " + EMPTY_EXERCISE_LIST);
        return driver.findElement(EMPTY_EXERCISE_LIST).getText();
    }

    @Step("Click Edit button")
    public MyCustomExercises clickEdit() {
        log.info("Click on the edit exercise button by " + EDIT_BUTTON);
        driver.findElement(EDIT_BUTTON).click();
        return new MyCustomExercises(driver);
    }

    @Step("Click Delete exercise button")
    public MyCustomExercises clickDelete() {
        log.info("Click on the delete exercise button by " + DELETE_BUTTON);
        driver.findElement(DELETE_BUTTON).click();
        return new MyCustomExercises(driver);
    }


}
