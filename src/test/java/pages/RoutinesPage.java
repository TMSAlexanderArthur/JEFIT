package pages;

import com.github.javafaker.Faker;
import elements.*;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class RoutinesPage extends BasePage {

    public static final By DOWNLOAD_A_ROUTINE_BUTTON = By.xpath("//a[text()='Download A Routine']");
    public static final By ROUTINE_NAME = By.xpath("descendant::a[@class ='confirmText'][1]/strong");
    public static final By DELETE_ROUTINE_BUTTON = By.xpath("//a[@class = 'confirmText']/img[@src= '../../../images/delete_icon1.png']");
    public static final By EDIT_ROUTINE_BUTTON = By.xpath("//a[@class = 'confirmText']/img[@src= '../../../images/edit_icon.png']");
    public static final By CHOOSE_A_5x5_WORKOUT = By.xpath("//div[normalize-space()='5x5 Strength Training Program']");
    public static final By ROUTINE_IS_DELETED = By.xpath("//p[contains(text(),'You have not setup a default routine yet. Please c')]");
    public static final By SHARED_WITH_ME_TAB = By.xpath("//a[@href = './shared-with-me.php']");
    public static final By MY_SUBMITS_TAB = By.xpath("//a[@href = './my-submits.php']");
    public static final By PROFILE_EDIT_TAB = By.xpath("//div[@class = 'profile-edit tab-pane active']");
    public static final By COUNT_ROUTINE = By.xpath("//td[normalize-space()='0/20 Routines Created']");


    String text = faker.cat().name();

    static Faker faker = new Faker();

    public RoutinesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Make sure the Compare Body is opened")
    public boolean isPageOpen() {
        log.info("Find element --> " + DOWNLOAD_A_ROUTINE_BUTTON);
        return isExist(DOWNLOAD_A_ROUTINE_BUTTON);
    }

    @Step("Open Routine page")
    public RoutinesPage open() {
        driver.get(BASE_URL + "/my-jefit/my-routines/routine-manager.php");
        log.info("Open routine page by URL");
        return this;
    }

    @Step("Create Routine")
    public RoutinesPage createRoutine() {
        new HrefButton(driver, "Create New Routine").click();
        new Input(driver, "rpname").write(text);
        new Select(driver, "dayselect").selectRandomOption();
        new Select(driver, "typeselect").selectRandomOption();
        new Select(driver, "levelselect").selectRandomOption();
        new TextArea(driver, "rptext").write(faker.chuckNorris().fact());
        new TextArea(driver, "rtags").write(faker.cat().name());
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value = 'Save']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        log.info("JS click on Save button");
        return this;
    }

    @Step("Get routine name")
    public String getRoutineName() {
        log.info("Get routine name by " + ROUTINE_NAME);
        return driver.findElement(ROUTINE_NAME).getText();
    }

    @Step("Get editing routine name")
    public String getEditingRoutineName() {
        log.info("Get editing routine name by " + ROUTINE_NAME);
        return driver.findElement(ROUTINE_NAME).getText();
    }

    @Step("Get faker text")
    public String returnRoutineFakerText() {
        log.info("Get faker text : " + text);
        return text;
    }

    @Step("Edit Routine")
    public RoutinesPage editRoutine() {
        driver.findElement(EDIT_ROUTINE_BUTTON).click();
        log.info("Click Edit Routine button by " + EDIT_ROUTINE_BUTTON);
        new Input(driver, "rpname").clear();
        new Input(driver, "rpname").write("Editing " + text);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value = 'Save']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        log.info("JS click on Save button");
        return this;
    }

    @Step("Delete routine")
    public RoutinesPage deleteRoutine() {
        driver.findElement(DELETE_ROUTINE_BUTTON).click();
        log.info("Click delete routine button by " + DELETE_ROUTINE_BUTTON);
        Alert alert = driver.switchTo().alert();
        wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        log.info("Switch to alert and accept");
        wait.until(ExpectedConditions.visibilityOfElementLocated(COUNT_ROUTINE))
        return this;
    }

    @Step("Click Download 5x5 Routine and click Save button")
    public RoutinesPage download5x5Routine() {
        new HrefButton(driver, "Download A Routine").click();
        driver.findElement(CHOOSE_A_5x5_WORKOUT).click();
        log.info("Click on button by " + CHOOSE_A_5x5_WORKOUT);
        new Button(driver, "Save To My Workouts").click();
        return this;
    }

    @Step("Make sure the Routine is deleted")
    public String routineIsDeletedText() {
        log.info("Get text by " + ROUTINE_IS_DELETED);
        return driver.findElement(ROUTINE_IS_DELETED).getText();
    }

    @Step("Open Shared With Me tab")
    public RoutinesPage openSharedWithMeTab() {
        driver.findElement(SHARED_WITH_ME_TAB).click();
        log.info("Click on Shared With Me tab by " + SHARED_WITH_ME_TAB);
        return this;
    }

    @Step("Open My Submits tab")
    public RoutinesPage openMySubmitsTab() {
        driver.findElement(MY_SUBMITS_TAB).click();
        log.info("Click on My Submits tab by " + MY_SUBMITS_TAB);

        return this;
    }

    @Step("Make sure the My Submits tab is opened")
    public boolean mySubmitsTabIsOpened() {
        log.info("Find element --> " + PROFILE_EDIT_TAB);
        return driver.findElement(PROFILE_EDIT_TAB).isDisplayed();
    }

    @Step("Get Shared with me URL")
    public String getSharedWithMeUrl() {
        log.info("Get URL Shared with me page");
        return driver.getCurrentUrl().trim();
    }

}
