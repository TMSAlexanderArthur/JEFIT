package tests;

import org.testng.annotations.Test;

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

}

