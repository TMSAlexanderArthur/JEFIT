package tests;

import models.BodyStats;
import models.BodyStatsFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LogWorkoutTest extends BaseTest {

    @Test
    public void addBodyStats() {
        loginPage.open()
                .login();
        BodyStats bodyStats = BodyStatsFactory.get();
        boolean isBodyStatsOpened = logWorkoutPage.open()
                .clickAddBodyStatsButton()
                .create(bodyStats).
                isPageOpen();

        assertTrue(isBodyStatsOpened, "Body Stats form hasn't opened");

        assertEquals(logWorkoutPage.getBodyStatsValue("Weight"), bodyStats.getWeight());
        assertEquals(logWorkoutPage.getBodyStatsValue("Body Fat"), bodyStats.getBodyFat());
        assertEquals(logWorkoutPage.getBodyStatsValue("Height"), bodyStats.getHeight());
        assertEquals(logWorkoutPage.getBodyStatsValue("Chest"), bodyStats.getChest());
        assertEquals(logWorkoutPage.getBodyStatsValue("Waist"), bodyStats.getWaist());
        assertEquals(logWorkoutPage.getBodyStatsValue("Arms"), bodyStats.getArms());
        assertEquals(logWorkoutPage.getBodyStatsValue("Shoulders"), bodyStats.getShoulders());
        assertEquals(logWorkoutPage.getBodyStatsValue("Foreams"), bodyStats.getForeams());
        assertEquals(logWorkoutPage.getBodyStatsValue("Neck"), bodyStats.getNeck());
        assertEquals(logWorkoutPage.getBodyStatsValue("Hips"), bodyStats.getHips());
        assertEquals(logWorkoutPage.getBodyStatsValue("Thighs"), bodyStats.getThighs());
        assertEquals(logWorkoutPage.getBodyStatsValue("Calves"), bodyStats.getCalves());



        logWorkoutPage.deleteBodyStats();

    }
}
