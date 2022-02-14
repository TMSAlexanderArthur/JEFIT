package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
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
        log.info("Write " + text + " into Input with name " + name);
    }

    public void clear() {
        driver.findElement(By.xpath(String.format(inputLocator, this.name))).clear();
        log.info("Clear input with name " + name);
    }

    public void click() {
        driver.findElement(By.xpath(String.format(inputLocator, this.name))).click();
        log.info("Click on input with name " + name);
    }

}