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

import java.io.File;
import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public abstract class BaseTest {
    public static String downloadPath = "C:\\Users\\Admin\\Downloads";

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProfileHomePage profileHomePage;
    protected GetJefitIOsAppPage getJefitIOsAppPage;
    protected GetJefitAndroidPage getJefitAndroidPage;
    protected WorkoutPlansPage workoutPlansPage;
    protected AboutMePage aboutMePage;
    protected UserPage userPage;
    protected LogWorkoutPage logWorkoutPage;
    protected ExercisesPage exercisesPage;
    protected AllExerciseDatabasePage allExerciseDatabasePage;
    protected BlogPage blogPage;
    protected CoachModePage coachModePage;
    protected GetElitePage getElitePage;
    protected NotificationsPage notificationsPage;
    protected FriendsPage friendsPage;
    protected SettingsProfileAppPage settingsProfileAppPage;
    protected SettingsEmailPasswordPage settingsEmailPasswordPage;
    protected SettingsMembershipPage settingsMembershipPage;
    protected SettingsNotificationPrivacyPage settingsNotificationPrivacyPage;
    protected MyMessagesPage myMessagesPage;
    protected MyLogsPage myLogsPage;
    protected MyPhotosPage myPhotosPage;
    protected MyCustomExercises myCustomExercises;
    protected MyReportsPage myReportsPage;
    protected RoutinesPage routinesPage;

    @BeforeMethod(description = "Setup and start browser")
    public void setUp(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
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
        settingsProfileAppPage = new SettingsProfileAppPage(driver);
        settingsEmailPasswordPage = new SettingsEmailPasswordPage(driver);
        settingsMembershipPage = new SettingsMembershipPage(driver);
        settingsNotificationPrivacyPage = new SettingsNotificationPrivacyPage(driver);
        myMessagesPage = new MyMessagesPage(driver);
        myLogsPage = new MyLogsPage(driver);
        myPhotosPage = new MyPhotosPage(driver);
        myCustomExercises = new MyCustomExercises(driver);
        myReportsPage = new MyReportsPage(driver);
        routinesPage = new RoutinesPage(driver);
    }

    public boolean isFileDownloaded_Ext(String dirPath, String ext) {
        boolean flag = false;
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            flag = false;
        }

        for (int i = 1; i < files.length; i++) {
            if (files[i].getName().contains(ext)) {
                flag = true;
            }
        }
        return flag;
    }

    public void deleteAllFilesFromDirectory() {
        File file = new File(downloadPath);
        String[] currentFiles;
        if (file.isDirectory()) {
            currentFiles = file.list();
            for (String currentFile : currentFiles) {
                File myFile = new File(file, currentFile);
                myFile.delete();
            }
        }
    }

    @AfterMethod(alwaysRun = true, description = "Close browser")
    public void tearDown() {
        driver.quit();
    }

}