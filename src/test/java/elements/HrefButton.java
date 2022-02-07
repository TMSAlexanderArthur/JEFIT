package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HrefButton {

    WebDriver driver;
    String text;

    String hrefButtonLocator = "//a[text()='%s']";


    public void click(){
        driver.findElement(By.xpath(String.format(hrefButtonLocator, text))).click();
    }

    public HrefButton(WebDriver driver, String text) {
        this.driver = driver;
        this.text = text;
    }
}
