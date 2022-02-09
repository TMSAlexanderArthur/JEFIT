package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectDropdown {

    WebDriver driver;
    String label;
    String selectLocator = "//select[@name='%s']";
    String selectedOptionLocator = "//select[@name='%s']/option[@selected]";

    public SelectDropdown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }


    public void click() {
        driver.findElement(By.xpath(String.format(selectLocator, label))).click();
    }

    public void getSelectedOption() {
        driver.findElement(By.xpath(String.format(selectedOptionLocator, label))).click();
    }


}
