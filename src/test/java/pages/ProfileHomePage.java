package pages;

import com.github.javafaker.Faker;
import elements.Button;
import elements.HrefButton;
import elements.TextArea;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;

public class ProfileHomePage extends BasePage {

    static Faker faker = new Faker();

    public static final By PROFILE_PIC = By.xpath("//img[@class ='leftProfilePic']");
    public static final By SELECT_FILE_BUTTON = By.id("avatarupload");


    public ProfileHomePage changeStatus(){
        new TextArea(driver, "statusinputbox").write(faker.chuckNorris().fact());
        return this;
    }

    public ProfileHomePage uploadProfilePic(){
        new HrefButton(driver,"Edit").click();
        File file = new File("src/test/resources/filesToUpload/qa-2-min (1).png");
        driver.findElement(SELECT_FILE_BUTTON).sendKeys(file.getAbsolutePath());
        new Button(driver, "Upload Photo").click();
        return this;
    }
    
    public String fileIsUploaded(){
        WebElement img = driver.findElement(PROFILE_PIC);
        return img.getAttribute("src");
    }

    public ProfileHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(PROFILE_PIC);
    }
}
