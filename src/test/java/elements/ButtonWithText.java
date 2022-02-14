package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ButtonWithText {
    WebDriver driver;
    String text;

    String buttonWithTextLocator = "//button[text()='%s']";

    public ButtonWithText(WebDriver driver, String text) {
        this.driver = driver;
        this.text = text;
    }

    public void clickButtonWithText() {
        driver.findElement(By.xpath(String.format(buttonWithTextLocator, text))).click();
    }

}
