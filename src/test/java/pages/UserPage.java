package pages;

import elements.HrefButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserPage extends BasePage{

    public static final By PROFILE_NAME = By.xpath("//span[@class = 'emptyLinkStub']/ancestor::ul");
    String fieldValue = "//span[text()='%s']/parent::div";

    @Override
    public boolean isPageOpen() {
        return isExist(PROFILE_NAME);
    }

    public UserPage(WebDriver driver) {
        super(driver);
    }

    public String getFieldValue(String fieldName){
       String[] value = driver.findElement(By.xpath(String.format(fieldValue,fieldName))).getText().split(":");
       return value[1].trim();
    }


    public UserPage open(){
        driver.get(BASE_URL + "user/testnametest");
        new HrefButton(driver, "More About Me").click();
        return this;
    }


}
