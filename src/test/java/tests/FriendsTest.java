
package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FriendsTest extends BaseTest {

    @Test(description = "Open friends")
    public void friendsShouldBeOpenedTest() {
        loginPage
                .open()
                .login();
        boolean isFriendsPageOpened = friendsPage
                .openMyFriends()
                .isPageOpen();

        assertTrue(isFriendsPageOpened, "Friends page hasn't opened");
    }

    @Test(description = "Open Blocked List")
    public void blockedListShouldBeOpenedTest() {
        loginPage
                .open()
                .login();
        friendsPage
                .openMyFriends()
                .openBlockedList();

        assertEquals(friendsPage.getContentBoxText(), "The block list is empty.", "Blocked list hasn't opened");
    }

    @Test(description = "Open Incoming Request")
    public void incomingRequestShouldBeOpenedTest() {
        loginPage
                .open()
                .login();
        friendsPage
                .openMyFriends()
                .openIncomingRequests();

        assertEquals(friendsPage.getContentBoxText(), "No incoming friend request.", "Incoming Requests tab hasn't opened");
    }

    @Test(description = "Open Search Friends")
    public void searchFriendsShouldBeOpenedTest() {
        loginPage
                .open()
                .login();
        friendsPage
                .openMyFriends()
                .openSearchFriends();

        assertEquals(friendsPage.getContentBoxText(), "Search and add your friends!", "Search Friends tab hasn't opened");
    }

    @Test(description = "Add new friend")
    public void newFriendShouldBeAdded() {
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