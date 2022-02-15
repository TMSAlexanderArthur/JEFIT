package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class LoginTest extends BaseTest {

    @DataProvider(name = "incorrectLoginTest")
    public Object[][] incorrectLoginTest() {
        return new Object[][]{
                {"wrongmail", "wrongpass", "Invalid username/email or password"},
                {"", "", "Invalid username/email or password"},
                {"wrongmail", "", "Invalid username/email or password"},
                {"", "wrongpass", "Invalid username/email or password"},
        };
    }

    @Test(description = "Log in with valid data")
    public void loginTest() {
        boolean isProfilePageOpened = loginPage.open()
                .login()
                .isPageOpen();

        assertTrue(isProfilePageOpened, "Page hasn't opened");
    }

    @Test(dataProvider = "incorrectLoginTest", description = "Attempting to log in using incorrect data")
    public void negativeLoginTest(String login, String password, String errorMessage) {
        loginPage
                .open()
                .loginWithsWrongData(login, password)
                .isPageOpen();

        assertEquals(loginPage.getErrorMessage(), errorMessage, "The text doesn't match");
    }


}