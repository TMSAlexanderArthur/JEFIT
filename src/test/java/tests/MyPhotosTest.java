package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Flaky;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class MyPhotosTest extends BaseTest {

    @Test(description = "Open My Photos")
    public void myPhotosShouldBeOpenedTest() {
        loginPage
                .open()
                .login();
        boolean isMyPhotosPageOpened = myPhotosPage
                .openMyPhotos()
                .isPageOpen();

        assertTrue(isMyPhotosPageOpened, "My Photos page hasn't opened");

    }

    @Test(description = "Create new Album")
    @Flaky
    public void newAlbumShouldBeCreatedTest() {
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
