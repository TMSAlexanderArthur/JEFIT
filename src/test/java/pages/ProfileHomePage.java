package pages;

import com.github.javafaker.Faker;
import elements.Button;
import elements.HrefButton;
import elements.TextArea;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

public class ProfileHomePage extends BasePage {
    Faker faker = new Faker();
    String text = faker.chuckNorris().fact();
    public static final By PROFILE_PIC = By.xpath("//img[@class ='leftProfilePic']");
    public static final By SELECT_FILE_BUTTON = By.id("avatarupload");
    public static final By STATUS_TEXT = By.xpath("//div[@id ='statusText']/child::div[@class='col-8']");
    public static final By MY_JEFIT_SPAN = By.xpath("//span[text()='My Jefit']");
    public static final By SIGN_OUT_LINK = By.xpath("//a[text()='Sign out']");

    public ProfileHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(PROFILE_PIC);
    }

    public void deleteStatus() {
        new Button(driver, "Post").click();
    }

    public void changeStatus() {
        new TextArea(driver, "statusinputbox").write(text);
        new Button(driver, "Post").click();
    }

    public LoginPage signOut() {
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(MY_JEFIT_SPAN);
        action.moveToElement(we).moveToElement(driver.findElement(SIGN_OUT_LINK)).click().build().perform();
        return new LoginPage(driver);
    }

    public String returnFakerText() {
        return text;
    }

    public String getStatusText() throws InterruptedException {
        Thread.sleep(3000);
        return driver.findElement(STATUS_TEXT).getText();
    }

    public void uploadProfilePic() {
        new HrefButton(driver, "Edit").click();
        File file = new File("src/test/resources/filesToUpload/qa-2-min (1).png");
        driver.findElement(SELECT_FILE_BUTTON).sendKeys(file.getAbsolutePath());
        new Button(driver, "Upload Photo").click();
    }

    public String fileIsUploaded() {
        WebElement img = driver.findElement(PROFILE_PIC);
        return img.getAttribute("src");
    }

}