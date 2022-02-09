package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SettingsTest extends BaseTest {

    @Test
    public void openSettingsTest() {
        loginPage
                .open()
                .login();
        boolean isSettingsPageOpened = settingsPage
                .openSettings()
                .isPageOpen();

        assertTrue(isSettingsPageOpened, "Settings page hasn't opened");

    }

    @Test
    public void editDateOfBirthTest() {
        loginPage
                .open()
                .login();
        boolean isSettingsPageOpened = settingsPage
                .openSettings()
                .isPageOpen();

        assertTrue(isSettingsPageOpened, "Settings page hasn't opened");

        boolean isSavedSettingsPageOpened = settingsPage
                .editDateOfBirth()
                .isPageOpen();

        assertTrue(isSavedSettingsPageOpened, "Settings page hasn't opened");
//        assertEquals(settingsPage.getEditedMonthOfBirth(), , "Month of birth doesn't match");


    }




}
