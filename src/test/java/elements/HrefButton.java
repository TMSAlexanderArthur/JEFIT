package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HrefButton {
    WebDriver driver;
    String text;

    String hrefLocator = "//a[text()='%s']";

    public void click() {
        driver.findElement(By.xpath(String.format(hrefLocator, text))).click();
    }

    public HrefButton(WebDriver driver, String text) {
        this.driver = driver;
        this.text = text;
    }

}


