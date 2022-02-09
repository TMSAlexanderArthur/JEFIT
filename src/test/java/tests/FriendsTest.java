package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class FriendsTest extends BaseTest {

    @Test
    public void openFriendsTest() {
        loginPage
                .open()
                .login();
        boolean isFriendsPageOpened = friendsPage
                .openMyFriends()
                .isPageOpen();

        assertTrue(isFriendsPageOpened, "Friends page hasn't opened");

    }


}
