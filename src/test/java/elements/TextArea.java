package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextArea {
    WebDriver driver;
    String name;
    String textAreaLocator = "//textarea[@name='%s']";

    public TextArea(WebDriver driver, String name) {
        this.driver = driver;
        this.name = name;
    }

    public void write(String text) {
        driver.findElement(By.xpath(String.format(textAreaLocator, this.name))).sendKeys(text);
    }

    public void clear(){
        driver.findElement(By.xpath(String.format(textAreaLocator, this.name))).clear();
    }


}