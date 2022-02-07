package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Button {
    WebDriver driver;
    String value;

    String buttonLocator = "//input[@value = '%s']";

    public Button(WebDriver driver, String value) {
        this.driver = driver;
        this.value = value;
    }

    public void click() {
        driver.findElement(By.xpath(String.format(buttonLocator, value))).click();
    }


}
