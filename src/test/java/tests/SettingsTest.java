package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static pages.SettingsNotificationPrivacyPage.*;

public class SettingsTest extends BaseTest {

    @Test
    public void openProfileAppSettingsTest() {
        loginPage
                .open()
                .login();
        boolean isSettingsPageOpened = settingsProfileAppPage
                .openProfileAppSettings()
                .isPageOpen();

        assertTrue(isSettingsPageOpened, "Profile App Settings page hasn't opened");

    }

    @Test
    public void editDataOfBirthTest() {
        loginPage
                .open()
                .login();
        boolean isSettingsPageOpened = settingsProfileAppPage
                .openProfileAppSettings()
                .isPageOpen();

        assertTrue(isSettingsPageOpened, "Profile App Settings page hasn't opened");

        boolean isSavedSettingsPageOpened = settingsProfileAppPage
                .editDataOfBirth()
                .saveDataOfBirth()
                .isPageOpen();

        assertTrue(isSavedSettingsPageOpened, "Profile App Settings page hasn't opened");
        assertEquals(settingsProfileAppPage.getSavedMonthOfBirth(), settingsProfileAppPage.getNewMonthOfBirth(), "Month of birth doesn't match");
        assertEquals(settingsProfileAppPage.getSavedDateOfBirth(), settingsProfileAppPage.getNewDateOfBirth(), "Date of birth doesn't match");
        assertEquals(settingsProfileAppPage.getSavedYearOfBirth(), settingsProfileAppPage.getNewYearOfBirth(), "Year of birth doesn't match");

    }

    @Test
    public void exportMyDataTest() throws InterruptedException {
        loginPage
                .open()
                .login();
        boolean isSettingsPageOpened = settingsProfileAppPage
                .openProfileAppSettings()
                .isPageOpen();

        assertTrue(isSettingsPageOpened, "Profile App Settings page hasn't opened");

        boolean isAfterDownloadSettingsPageOpened = settingsProfileAppPage
                .exportData()
                .isPageOpen();
        assertTrue(isAfterDownloadSettingsPageOpened, "Profile App Settings page hasn't opened");

        assertTrue(isFileDownloaded_Ext(downloadPath, ".csv"), "Failed to download document which has extension .csv");
        deleteAllFilesFromDirectory();
    }

    @Test
    public void openEmailPasswordSettingsTest() {
        loginPage
                .open()
                .login();
        boolean isEmailPasswordSettingsPageOpened = settingsEmailPasswordPage
                .openEmailPasswordSettings()
                .isPageOpen();

        assertTrue(isEmailPasswordSettingsPageOpened, "Email Password Settings page hasn't opened");

    }

    @Test
    public void membershipIsRegularTest() {
        loginPage
                .open()
                .login();
        boolean isMembershipSettingsPageOpened = settingsMembershipPage
                .openMembershipSettings()
                .isPageOpen();

        assertTrue(isMembershipSettingsPageOpened, "Membership Settings page hasn't opened");
        assertEquals(settingsMembershipPage.getAccountType(), "Account Type : Regular", "Type of account doesn't match");
    }

    @Test
    public void manageNotificationsTest() {
        loginPage
                .open()
                .login();
        boolean isNotificationsSettingsPageOpened = settingsNotificationPrivacyPage
                .openNotificationPrivacySettings()
                .editNotificationsReport()
                .isPageOpen();

        assertTrue(isNotificationsSettingsPageOpened, "Notifications Settings page hasn't opened");
        assertTrue(driver.findElement(NOTIFICATIONS_OPTION_CHECKED).isSelected(), "Notification radio-button isn't checked");

    }

    @Test
    public void managePrivacyTest() {
        loginPage
                .open()
                .login();
        boolean isPrivacySettingsPageOpened = settingsNotificationPrivacyPage
                .openNotificationPrivacySettings()
                .editPrivacySettings()
                .isPageOpen();

        assertTrue(isPrivacySettingsPageOpened, "Privacy Settings page hasn't opened");
        assertTrue(driver.findElement(PRIVACY_OPTION_CHECKED).isSelected(), "Privacy radio-button isn't checked");

    }


}