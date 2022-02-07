package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import utils.TestListener;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public abstract class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProfilePage profilePage;
    protected GetJefitIOsAppPage getJefitIOsAppPage;
    protected GetJefitAndroidPage getJefitAndroidPage;
    protected WorkoutPlansPage workoutPlansPage;



    @BeforeMethod(description = "Setup and start browser")
    public void setUp(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        context.setAttribute("driver", driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        getJefitIOsAppPage = new GetJefitIOsAppPage(driver);
        getJefitAndroidPage = new GetJefitAndroidPage(driver);
        workoutPlansPage = new WorkoutPlansPage(driver);

    }

    @AfterMethod(alwaysRun = true, description = "Close browser")
    public void tearDown() {
        driver.quit();
    }

}

