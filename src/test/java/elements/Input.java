package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Input {
    WebDriver driver;
    String name;
    String inputLocator = "//input[@name = '%s']";

    public Input(WebDriver driver, String name) {
        this.driver = driver;
        this.name = name;
    }

    public void write(String text) {
        driver.findElement(By.xpath(String.format(inputLocator, this.name))).sendKeys(text);
    }

    public void clear() {
        driver.findElement(By.xpath(String.format(inputLocator, this.name))).clear();
    }

}