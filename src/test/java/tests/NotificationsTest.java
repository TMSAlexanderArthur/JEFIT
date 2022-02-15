package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class NotificationsTest extends BaseTest {

    @Test(description = "Open notifications")
    public void notificationShouldBeOpenedTest() {
        loginPage
                .open()
                .login();
        boolean isNotificationsPageOpened = notificationsPage
                .openNotifications()
                .isPageOpen();

        assertTrue(isNotificationsPageOpened, "Notifications page hasn't opened");

    }

}
