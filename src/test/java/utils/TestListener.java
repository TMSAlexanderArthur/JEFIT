package utils;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Log4j2
public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        log.info(String.format("TEST %s STARTED", result.getName()));

    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("TEST FINISH");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        log.info(String.format("TEST %s FAILED WITH TIMEOUT", result.getName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info(String.format("TEST %s SUCCESS", result.getName()));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        AllureUtils.takeScreenshot(driver);
        log.error(String.format("Test %s failure", result.getName()));
    }


}
