package tests;

import models.AboutMe;
import models.AboutMeFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AboutMeTest extends BaseTest {

    @Test
    public void aboutMeShouldBeCreated() {
        loginPage.open()
                .login();

        AboutMe aboutMe = AboutMeFactory.get();

        aboutMePage.open()
                .create(aboutMe);

        boolean isUserPageOpened = userPage
                .open()
                .isPageOpen();

        assertTrue(isUserPageOpened, "User page hasn't opened");

        assertEquals(userPage.getFieldValue("Occupation"), aboutMe.getT2(), "The text doesn't match");
        assertEquals(userPage.getFieldValue("Main Goal"), aboutMe.getT7(), "The text doesn't match");
        assertEquals(userPage.getFieldValue("Why Do You Workout"), aboutMe.getT4(), "The text doesn't match");
        assertEquals(userPage.getFieldValue("What Motivates You"), aboutMe.getT6(), "The text doesn't match");
        assertEquals(userPage.getFieldValue("How Did Your Start"), aboutMe.getT5(), "The text doesn't match");
        assertEquals(userPage.getFieldValue("Short Term Goals"), aboutMe.getT9(), "The text doesn't match");
        assertEquals(userPage.getFieldValue("Long Term Goals"), aboutMe.getT8(), "The text doesn't match");
        assertEquals(userPage.getFieldValue("Exercises"), aboutMe.getT13(), "The text doesn't match");
        assertEquals(userPage.getFieldValue("Supplements"), aboutMe.getT12(), "The text doesn't match");
        assertEquals(userPage.getFieldValue("Interest"), aboutMe.getT3(), "The text doesn't match");
        assertEquals(userPage.getFieldValue("Food"), aboutMe.getT11(), "The text doesn't match");
        assertEquals(userPage.getFieldValue("Music"), aboutMe.getT10(), "The text doesn't match");
        assertEquals(userPage.getFieldValue("Movies"), aboutMe.getT15(), "The text doesn't match");
        assertEquals(userPage.getFieldValue("Magazines"), aboutMe.getT14(), "The text doesn't match");

        aboutMePage.open()
                .clearAllFields();

    }
}
