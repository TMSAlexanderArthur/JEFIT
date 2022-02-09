package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProfileHomeTest extends BaseTest {

    @Test
    public void uploadPhotoTest() {
        loginPage.open()
                .login();

        profileHomePage.uploadProfilePic();

        String src = profileHomePage.fileIsUploaded();
        assertTrue(src.contains("avatar"), "Picture not uploaded");
    }

    @Test
    public void changeStatus() throws InterruptedException {
        loginPage.open()
                .login();
        profileHomePage.changeStatus();


        assertEquals( profileHomePage.getStatusText(), "Status : " + profileHomePage.returnFakerText(), "The text doesn't match");
    }

    @Test
    public void deleteStatus() throws InterruptedException {
        loginPage.open()
                .login();
        profileHomePage.deleteStatus();

        assertEquals(profileHomePage.getStatusText(), "Status" , "Status is not deleted");
    }

    @Test
    public void signOutTest() {
        loginPage.open()
                .login();

        boolean isLoginPageOpened = profileHomePage
                .signOut()
                .isPageOpen();

        assertTrue(isLoginPageOpened, "Login page hasn't opened");
    }

}