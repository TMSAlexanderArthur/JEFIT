package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class ButtonWithText {
    WebDriver driver;
    String text;

    String buttonWithTextLocator = "//button[text()='%s']";

    public ButtonWithText(WebDriver driver, String text) {
        this.driver = driver;
        this.text = text;
    }

    public void clickButtonWithText() {
        log.info("Click on button with text : " + text);
        driver.findElement(By.xpath(String.format(buttonWithTextLocator, text))).click();
    }

}
