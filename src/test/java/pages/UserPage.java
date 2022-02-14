package pages;

import elements.HrefButton;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class UserPage extends BasePage {

    public static final By PROFILE_NAME = By.xpath("//span[@class = 'emptyLinkStub']/ancestor::ul");
    String fieldValue = "//span[text()='%s']/parent::div";

    @Override
    public boolean isPageOpen() {
        return isExist(PROFILE_NAME);
    }

    public UserPage(WebDriver driver) {
        super(driver);
    }

    public String getFieldValue(String fieldName) {
        String[] value = driver.findElement(By.xpath(String.format(fieldValue, fieldName))).getText().split(":");
        log.info("Get text : " + value[1].trim() + " from field " + fieldName);
        return value[1].trim();
    }


    public UserPage open() {
        driver.get(BASE_URL + "user/testnametest");
        new HrefButton(driver, "More About Me").click();
        log.info("Open User Page");
        return this;
    }


}