package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class MyPhotosTest extends BaseTest {

    @Test
    public void openMyPhotosTest() {
        loginPage
                .open()
                .login();
        boolean isMyPhotosPageOpened = myPhotosPage
                .openMyPhotos()
                .isPageOpen();

        assertTrue(isMyPhotosPageOpened, "My Photos page hasn't opened");

    }

    @Test(description = "Bug: This test fails with Error 403")
    public void createNewAlbumTest() {
        loginPage
                .open()
                .login();
        myPhotosPage
                .openMyPhotos()
                .createNewAlbum();
        boolean isMyPhotosPageOpened = myPhotosPage
                .isPageOpen();

        assertTrue(isMyPhotosPageOpened, "New Album hasn't created");

    }


}
