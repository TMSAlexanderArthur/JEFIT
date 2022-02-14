package pages;

import com.github.javafaker.Faker;
import elements.Button;
import elements.SelectDropdown;
import elements.TextArea;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MyPhotosPage extends BasePage {
    public static final By MY_PHOTOS_TAB = By.xpath("//a/li[text()=' My Photos']");
    public static final By FIRST_PROGRESS_ALBUM = By.xpath("(//div[@title='Progress Pictures'])[1]");
    public static final By VISIBILITY_OPTIONS = By.xpath("//option");

    static Faker faker = new Faker();

    public MyPhotosPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(FIRST_PROGRESS_ALBUM);
    }

    public MyPhotosPage openMyPhotos() {
        driver.findElement(MY_PHOTOS_TAB).click();
        return new MyPhotosPage(driver);
    }

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
