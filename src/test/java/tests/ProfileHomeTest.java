package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProfileHomeTest extends BaseTest {

    @Test(description = "Upload Profile Picture")
    public void photoShoutBeUploadedTest() {
        loginPage.open()
                .login();

        profileHomePage.uploadProfilePic();

        String src = profileHomePage.fileIsUploaded();
        assertTrue(src.contains("avatar"), "Picture not uploaded");
    }

    @Test(description = "Change status ")
    public void statusShouldBeChangedTest() throws InterruptedException {
        loginPage.open()
                .login();
        profileHomePage.changeStatus();


        assertEquals(profileHomePage.getStatusText(), "Status : " + profileHomePage.returnFakerText(), "The text doesn't match");
    }

    @Test(description = "Delete status")
    public void statusShouldBeDeletedTest() throws InterruptedException {
        loginPage.open()
                .login();
        profileHomePage.deleteStatus();

        assertEquals(profileHomePage.getStatusText(), "Status", "Status is not deleted");
    }

    @Test(description = "Sign out")
    public void signOutTest() {
        loginPage.open()
                .login();

        boolean isLoginPageOpened = profileHomePage
                .signOut()
                .isPageOpen();

        assertTrue(isLoginPageOpened, "Login page hasn't opened");
    }

}