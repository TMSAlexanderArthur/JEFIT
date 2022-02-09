package pages;

import elements.SelectDropdown;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static pages.NotificationsPage.MY_JEFIT_SPAN;

@Log4j2
public class SettingsPage extends BasePage {
    public static final By SETTINGS_SPAN = By.xpath("//a[text()='Settings']");
    public static final By SAVE_PROFILE_BUTTON = By.xpath("//button[@value='Save Settings']");

    public static final By MONTH_OPTIONS = By.xpath("//select[@id='monthSelect']/option");
    public static final By DATE_OPTIONS = By.xpath("//select[@id='dateSelect']/option");
    public static final By YEAR_OPTIONS = By.xpath("//select[@id='yearSelect']/option");


    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(SAVE_PROFILE_BUTTON);
    }

    public SettingsPage openSettings() {
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(MY_JEFIT_SPAN);
        action.moveToElement(we).moveToElement(driver.findElement(SETTINGS_SPAN)).click().build().perform();
        return new SettingsPage(driver);
    }

    public SettingsPage editDateOfBirth() {
        SelectDropdown dropdownMonth = new SelectDropdown(driver, "month");
        SelectDropdown dropdownDate = new SelectDropdown(driver, "dt");
        SelectDropdown dropdownYear = new SelectDropdown(driver, "year");

        for (int i = 0; i < 11; i++) {
            dropdownMonth.click();
            List<WebElement> itemsInDropdown = driver.findElements(MONTH_OPTIONS);
            int size = itemsInDropdown.size();
            int randomNumber = ThreadLocalRandom.current().nextInt(0, size);
            itemsInDropdown.get(randomNumber).click();
        }

        for (int i = 0; i < 30; i++) {
            dropdownDate.click();
            List<WebElement> itemsInDropdown = driver.findElements(DATE_OPTIONS);
            int size = itemsInDropdown.size();
            int randomNumber = ThreadLocalRandom.current().nextInt(0, size);
            itemsInDropdown.get(randomNumber).click();
        }

        for (int i = 0; i < 82; i++) {
            dropdownYear.click();
            List<WebElement> itemsInDropdown = driver.findElements(YEAR_OPTIONS);
            int size = itemsInDropdown.size();
            int randomNumber = ThreadLocalRandom.current().nextInt(0, size);
            itemsInDropdown.get(randomNumber).click();
        }
        driver.findElement(SAVE_PROFILE_BUTTON).click();
        return new SettingsPage(driver);
    }

    public void getEditedMonthOfBirth() {
        log.info(">>>>>>>Get New Month Of Birth");
        SelectDropdown dropdownMonth = new SelectDropdown(driver, "month");
        dropdownMonth.getSelectedOption();
    }

//    public String getNewDateOfBirth() {
//        log.info(">>>>>>>Get New Date Of Birth");
//        return driver.findElement(By.xpath(String.format(websiteDetailsLocator))).getText();
//    }
//
//    public String getNewYearOfBirth() {
//        log.info(">>>>>>>Get New Year Of Birth");
//        return driver.findElement(By.xpath(String.format(parentAccountDetailsLocator))).getText();
//    }


}
