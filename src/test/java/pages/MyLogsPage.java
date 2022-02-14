package pages;

import elements.HrefButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MyLogsPage extends BasePage {
    public static final By LOGS_TITLE = By.xpath("//strong");
    public static final By CALENDAR_DAY_LOGS = By.xpath("(//td[@class='calenderDay']/a)[15]");
    public static final By EDIT_BODY_STATS = By.xpath("//span[@id='edit-body-stats']");

    public MyLogsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(LOGS_TITLE);
    }

    public MyLogsPage openMyLogs() {
        new HrefButton(driver, " My Logs").click();
        return new MyLogsPage(driver);
    }

    public void openLogsForDay() {
        driver.findElement(CALENDAR_DAY_LOGS).click();
    }

    public boolean editBodyStatsIsDisplayed() {
        return driver.findElement(EDIT_BODY_STATS).isDisplayed();
    }

}
