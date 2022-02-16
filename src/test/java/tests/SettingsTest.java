package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static pages.SettingsNotificationPrivacyPage.*;

public class SettingsTest extends BaseTest {

    @Test(description = "Open Profile Settings App")
    public void profileSettingsAppShouldBeOpenedTest() {
        loginPage
                .open()
                .login();
        boolean isSettingsPageOpened = settingsProfileAppPage
                .openProfileAppSettings()
                .isPageOpen();

        assertTrue(isSettingsPageOpened, "Profile App Settings page hasn't opened");

    }

    @Test(description = "Edit data of birth")
    public void dataOfBirthShouldBeEditingTest() {
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

    @Test(description = "Export My Data")
    public void myDataShouldBeExportedTest() throws InterruptedException {
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

        assertTrue(isFileDownloaded_Ext(downloadPath, "Test"), "Failed to download document which has extension .csv");
        deleteAllFilesFromDirectory();
    }

    @Test(description = "Open Email Password Settings page")
    public void emailPasswordSettingsShouldBeOpenedTest() {
        loginPage
                .open()
                .login();
        boolean isEmailPasswordSettingsPageOpened = settingsEmailPasswordPage
                .openEmailPasswordSettings()
                .isPageOpen();

        assertTrue(isEmailPasswordSettingsPageOpened, "Email Password Settings page hasn't opened");

    }

    @Test(description = "Open Member Ship Settings page")
    public void memberShipSettingsShouldBeOpenedTest() {
        loginPage
                .open()
                .login();
        boolean isMembershipSettingsPageOpened = settingsMembershipPage
                .openMembershipSettings()
                .isPageOpen();

        assertTrue(isMembershipSettingsPageOpened, "Membership Settings page hasn't opened");
        assertEquals(settingsMembershipPage.getAccountType(), "Account Type : Regular", "Type of account doesn't match");
    }

    @Test(description = "Manage Notifications ")
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

    @Test(description = "Manage Privacy")
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