package tests;

import models.AboutMe;
import models.AboutMeFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AboutMeTest extends BaseTest {

    @Test
    public void aboutMeShouldBeCreatedTest() {
        loginPage.open()
                .login();

        AboutMe aboutMe = AboutMeFactory.get();

        aboutMePage.open()
                .create(aboutMe);

        boolean isUserPageOpened = userPage
                .open()
                .isPageOpen();

        assertTrue(isUserPageOpened, "User page hasn't opened");

        assertEquals(userPage.getFieldValue("Occupation"), aboutMe.getT2());
        assertEquals(userPage.getFieldValue("Main Goal"), aboutMe.getT7());
        assertEquals(userPage.getFieldValue("Why Do You Workout"), aboutMe.getT4());
        assertEquals(userPage.getFieldValue("What Motivates You"), aboutMe.getT6());
        assertEquals(userPage.getFieldValue("How Did Your Start"), aboutMe.getT5());
        assertEquals(userPage.getFieldValue("Short Term Goals"), aboutMe.getT9());
        assertEquals(userPage.getFieldValue("Long Term Goals"), aboutMe.getT8());
        assertEquals(userPage.getFieldValue("Exercises"), aboutMe.getT13());
        assertEquals(userPage.getFieldValue("Supplements"), aboutMe.getT12());
        assertEquals(userPage.getFieldValue("Interest"), aboutMe.getT3());
        assertEquals(userPage.getFieldValue("Food"), aboutMe.getT11());
        assertEquals(userPage.getFieldValue("Music"), aboutMe.getT10());
        assertEquals(userPage.getFieldValue("Movies"), aboutMe.getT15());
        assertEquals(userPage.getFieldValue("Magazines"), aboutMe.getT14());

        aboutMePage.open()
                .clearAllFields();

    }
}
