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
    protected ProfileHomePage profileHomePage;
    protected GetJefitIOsAppPage getJefitIOsAppPage;
    protected GetJefitAndroidPage getJefitAndroidPage;
    protected WorkoutPlansPage workoutPlansPage;
    protected ExercisesPage exercisesPage;
    protected AllExerciseDatabasePage allExerciseDatabasePage;
    protected BlogPage blogPage;
    protected CoachModePage coachModePage;
    protected GetElitePage getElitePage;
    protected NotificationsPage notificationsPage;
    protected FriendsPage friendsPage;
    protected SettingsPage settingsPage;
    protected AboutMePage aboutMePage;
    protected UserPage userPage;
    protected LogWorkoutPage logWorkoutPage;


    @BeforeMethod(description = "Setup and start browser")
    public void setUp(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        context.setAttribute("driver", driver);
        loginPage = new LoginPage(driver);
        profileHomePage = new ProfileHomePage(driver);
        getJefitIOsAppPage = new GetJefitIOsAppPage(driver);
        getJefitAndroidPage = new GetJefitAndroidPage(driver);
        workoutPlansPage = new WorkoutPlansPage(driver);
        aboutMePage = new AboutMePage(driver);
        userPage = new UserPage(driver);
        logWorkoutPage = new LogWorkoutPage(driver);
        exercisesPage = new ExercisesPage(driver);
        allExerciseDatabasePage = new AllExerciseDatabasePage(driver);
        blogPage = new BlogPage(driver);
        coachModePage = new CoachModePage(driver);
        getElitePage = new GetElitePage(driver);
        notificationsPage = new NotificationsPage(driver);
        friendsPage = new FriendsPage(driver);
        settingsPage = new SettingsPage(driver);

    }

    @AfterMethod(alwaysRun = true, description = "Close browser")
    public void tearDown() {
        driver.quit();
    }

}

