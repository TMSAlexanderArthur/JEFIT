package pages;

import com.github.javafaker.Faker;
import elements.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RoutinesPage extends BasePage{

    public static final By DOWNLOAD_A_ROUTINE_BUTTON = By.xpath("//a[text()='Download A Routine']");
    public static final By ROUTINE_NAME = By.xpath("descendant::a[@class ='confirmText'][1]/strong");
    public static final By DELETE_ROUTINE_BUTTON = By.xpath("//a[@class = 'confirmText']/img[@src= '../../../images/delete_icon1.png']");
    public static final By EDIT_ROUTINE_BUTTON = By.xpath("//a[@class = 'confirmText']/img[@src= '../../../images/edit_icon.png']");
    public static final By CHOOSE_A_5x5_WORKOUT = By.xpath("//div[normalize-space()='5x5 Strength Training Program']");
    public static final By ROUTINE_IS_DELETED = By.xpath("//p[contains(text(),'You have not setup a default routine yet. Please c')]");
    public static final By SHARED_WITH_ME_TAB = By.xpath("//a[@href = './shared-with-me.php']");
    public static final By MY_SUBMITS_TAB = By.xpath("//a[@href = './my-submits.php']");
    public static final By PROFILE_EDIT_TAB = By.xpath("//div[@class = 'profile-edit tab-pane active']");

    String text = faker.cat().name();

    static Faker faker = new Faker();

    public RoutinesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(DOWNLOAD_A_ROUTINE_BUTTON);
    }

    public RoutinesPage open(){
        driver.get(BASE_URL + "/my-jefit/my-routines/routine-manager.php");
        return this;
    }

    public RoutinesPage createRoutine(){
        new HrefButton(driver, "Create New Routine").click();
        new Input(driver, "rpname").write(text);
        new Select(driver, "dayselect").selectRandomOption();
        new Select(driver, "typeselect").selectRandomOption();
        new Select(driver, "levelselect").selectRandomOption();
        new TextArea(driver, "rptext").write(faker.chuckNorris().fact());
        new TextArea(driver, "rtags").write(faker.cat().name());
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value = 'Save']")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
        return this;
    }

    public String getRoutineName(){
        return driver.findElement(ROUTINE_NAME).getText();
    }

    public String getEditingRoutineName(){ return driver.findElement(ROUTINE_NAME).getText(); }

    public String returnRoutineFakerText(){
        return text;
    }

    public RoutinesPage editRoutine(){
        driver.findElement(EDIT_ROUTINE_BUTTON).click();
        new Input(driver, "rpname").clear();
        new Input(driver, "rpname").write("Editing " + text);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value = 'Save']")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
        return this;
    }

    public RoutinesPage deleteRoutine(){
        driver.findElement(DELETE_ROUTINE_BUTTON).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return this;
    }

   public RoutinesPage download5x5Routine(){
        new HrefButton(driver, "Download A Routine").click();
        driver.findElement(CHOOSE_A_5x5_WORKOUT).click();
        new Button(driver, "Save To My Workouts").click();
        return this;
   }

   public String routineIsDeletedText(){
        return driver.findElement(ROUTINE_IS_DELETED).getText();
    }

    public RoutinesPage openSharedWithMeTab(){
        driver.findElement(SHARED_WITH_ME_TAB).click();
        return this;
    }

    public RoutinesPage openMySubmitsTab(){
        driver.findElement(MY_SUBMITS_TAB).click();
        return this;
    }

    public boolean mySubmitsTabIsOpened(){
        return driver.findElement(PROFILE_EDIT_TAB).isDisplayed();
    }

    public String getSharedWithMeUrl(){
       return driver.getCurrentUrl().trim();
    }

}
