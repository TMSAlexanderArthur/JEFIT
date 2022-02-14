package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
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

    @Test
    public void openBlockedListTest() {
        loginPage
                .open()
                .login();
        friendsPage
                .openMyFriends()
                .openBlockedList();

        assertEquals(friendsPage.getContentBoxText(), "The block list is empty.", "Blocked list hasn't opened");
    }

    @Test
    public void openIncomingRequestTest() {
        loginPage
                .open()
                .login();
        friendsPage
                .openMyFriends()
                .openIncomingRequests();

        assertEquals(friendsPage.getContentBoxText(), "No incoming friend request.", "Incoming Requests tab hasn't opened");
    }

    @Test
    public void openSearchFriendsTest() {
        loginPage
                .open()
                .login();
        friendsPage
                .openMyFriends()
                .openSearchFriends();

        assertEquals(friendsPage.getContentBoxText(), "Search and add your friends!", "Search Friends tab hasn't opened");
    }

    @Test
    public void addNewFriendTest() {
        loginPage
                .open()
                .login();
        friendsPage
                .openMyFriends()
                .openSearchFriends()
                .addNewFriend();
        assertTrue(friendsPage.requestSentInvitationIsDisplayed(), "Invitation to friend hasn't sent");
    }

}
