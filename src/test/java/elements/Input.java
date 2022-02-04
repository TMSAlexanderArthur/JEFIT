package elements;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class Input {

    WebDriver driver;
    String label;
    String inputLocator = "//input[@placeholder='  %s']";

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }


    public void write(String text){
        driver.findElement(By.xpath(String.format(inputLocator, this.label))).sendKeys(text);
    }

}
