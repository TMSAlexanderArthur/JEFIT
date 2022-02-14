package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class MyMessagesTest extends BaseTest {

    @Test
    public void openMyMessagesTest() {
        loginPage
                .open()
                .login();
        boolean isMyMessagesPageOpened = myMessagesPage
                .openMyMessages()
                .isPageOpen();

        assertTrue(isMyMessagesPageOpened, "My Messages page hasn't opened");

    }

}
