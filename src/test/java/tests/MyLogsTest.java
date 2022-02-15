package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class MyLogsTest extends BaseTest {

    @Test(description = "Open My Logs")
    public void myLogsShouldBeOpenedTest() {
        loginPage
                .open()
                .login();
        boolean isMyLogsPageOpened = myLogsPage
                .openMyLogs()
                .isPageOpen();

        assertTrue(isMyLogsPageOpened, "My Logs page hasn't opened");

    }

    @Test(description = "Open Logs For Day")
    public void logsForDayShouldBeOpenedTest() {
        loginPage
                .open()
                .login();
        boolean isMyLogsPageOpened = myLogsPage
                .openMyLogs()
                .isPageOpen();
        myLogsPage
                .openLogsForDay();

        assertTrue(isMyLogsPageOpened, "My Logs page hasn't opened");
        assertTrue(myLogsPage.editBodyStatsIsDisplayed(), "Logs for day hasn't opened");

    }


}
