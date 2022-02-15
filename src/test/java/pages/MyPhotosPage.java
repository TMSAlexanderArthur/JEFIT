package pages;

import com.github.javafaker.Faker;
import elements.Button;
import elements.SelectDropdown;
import elements.TextArea;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Log4j2
public class MyPhotosPage extends BasePage {
    public static final By MY_PHOTOS_TAB = By.xpath("//a/li[text()=' My Photos']");
    public static final By FIRST_PROGRESS_ALBUM = By.xpath("(//div[@title='Progress Pictures'])[1]");
    public static final By VISIBILITY_OPTIONS = By.xpath("//option");

    static Faker faker = new Faker();

    public MyPhotosPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Find element to make sure the page is open")
    public boolean isPageOpen() {
        log.info("Find element --> " + FIRST_PROGRESS_ALBUM);
        return isExist(FIRST_PROGRESS_ALBUM);
    }

    @Step("Open My Photos")
    public MyPhotosPage openMyPhotos() {
        driver.findElement(MY_PHOTOS_TAB).click();
        log.info("Click on My Photos tab by " + MY_PHOTOS_TAB);
        return new MyPhotosPage(driver);
    }

    @Step("Create New album")
    public void createNewAlbum() {
        new Button(driver, "Create New Album").click();
        new TextArea(driver, "myalbumTitle").write(faker.esports().team());
        new TextArea(driver, "myalbumDesc").write(faker.witcher().location());

        SelectDropdown dropdownVisibility = new SelectDropdown(driver, "mystate");
        dropdownVisibility.click();
        List<WebElement> optionsInDropdown = driver.findElements(VISIBILITY_OPTIONS);
        int typeSize = optionsInDropdown.size();
        int randomType = ThreadLocalRandom.current().nextInt(0, typeSize);
        optionsInDropdown.get(randomType).click();

        new Button(driver, "Save Album").click();
    }


}
