package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class SelectDropdown {

    WebDriver driver;
    String name;
    String selectLocator = "//select[@name='%s']";
    String selectedOptionLocator = "//select[@name='%s']/option[@selected]";

    public SelectDropdown(WebDriver driver, String name) {
        this.driver = driver;
        this.name = name;
    }

    public void click() {
        log.info("Click on select with name : " + name);
        driver.findElement(By.xpath(String.format(selectLocator, name))).click();
    }

    public String getSavedSelectedOption() {
        log.info("Get saved option in select with name : " + name);
        return driver.findElement(By.xpath(String.format(selectedOptionLocator, name))).getText();
    }


}