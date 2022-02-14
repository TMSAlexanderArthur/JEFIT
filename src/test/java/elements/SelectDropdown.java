package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        driver.findElement(By.xpath(String.format(selectLocator, name))).click();
    }

    public String getSavedSelectedOption() {
        return driver.findElement(By.xpath(String.format(selectedOptionLocator, name))).getText();
    }


}