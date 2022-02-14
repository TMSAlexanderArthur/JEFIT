package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
@Log4j2
public class Select {
    WebDriver driver;
    String name;
    String selectLocator = "//select[@name='%s']";

    public Select(WebDriver driver, String name) {
        this.driver = driver;
        this.name = name;
    }

    public void selectRandomOption(){
        WebElement element = driver.findElement(By.xpath(String.format(selectLocator, name)));
        org.openqa.selenium.support.ui.Select select = new org.openqa.selenium.support.ui.Select(element);
        List<WebElement> options = select.getOptions();
        int size = options.size();
        int randomNumber = ThreadLocalRandom.current().nextInt(0, size);
        select.selectByIndex(randomNumber);
        select.getFirstSelectedOption();
        log.info("Select random option in select with name " + name);
    }
}
