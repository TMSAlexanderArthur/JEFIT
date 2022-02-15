package pages;

import com.github.javafaker.Faker;
import elements.Button;
import elements.HrefButton;
import elements.TextArea;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

@Log4j2
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
    @Step("Find element to make sure the page is open")
    public boolean isPageOpen() {
        log.info("Find element --> " + PROFILE_PIC);
        return isExist(PROFILE_PIC);
    }

    @Step("Delete status")
    public void deleteStatus() {
        new Button(driver, "Post").click();
        log.info("Delete status");
    }

    @Step("Edit status")
    public void changeStatus() {
        new TextArea(driver, "statusinputbox").write(text);
        new Button(driver, "Post").click();
        log.info("Change status");
    }

    @Step("Sign out")
    public LoginPage signOut() {
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(MY_JEFIT_SPAN);
        action.moveToElement(we).moveToElement(driver.findElement(SIGN_OUT_LINK)).click().build().perform();
        log.info("Use action and sign out");
        return new LoginPage(driver);
    }

    @Step("Get faker text")
    public String returnFakerText() {
        log.info("Return text : " + text);
        return text;
    }

    @Step("Get status text")
    public String getStatusText() throws InterruptedException {
        Thread.sleep(3000);
        log.debug("Sleep 3 seconds");
        log.info("Get status text by " + STATUS_TEXT);
        return driver.findElement(STATUS_TEXT).getText();
    }

    @Step("Upload profile page")
    public void uploadProfilePic() {
        new HrefButton(driver, "Edit").click();
        File file = new File("src/test/resources/filesToUpload/qa-2-min (1).png");
        driver.findElement(SELECT_FILE_BUTTON).sendKeys(file.getAbsolutePath());
        log.info("Select a file: " + file.getName() + " path file: " + file.getAbsolutePath() + " to upload");
        new Button(driver, "Upload Photo").click();
    }

    @Step("Make sure the profile picture is uploaded")
    public String fileIsUploaded() {
        WebElement img = driver.findElement(PROFILE_PIC);
        log.info("File is uploaded");
        return img.getAttribute("src");
    }

}