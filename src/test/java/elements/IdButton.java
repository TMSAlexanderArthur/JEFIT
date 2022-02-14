package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class IdButton {

    WebDriver driver;
    String id;

    String idLocator = "%s";

    public IdButton(WebDriver driver, String id) {
        this.driver = driver;
        this.id = id;
    }

    public void click() {
        driver.findElement(By.id(String.format(idLocator, id))).click();
        log.info("Click on button with id : " + id);
    }
}
