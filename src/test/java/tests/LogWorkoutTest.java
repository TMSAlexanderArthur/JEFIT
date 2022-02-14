package tests;

import models.BodyStats;
import models.BodyStatsFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LogWorkoutTest extends BaseTest {

    @Test
    public void addBodyStatsShouldBeCreated() {
        loginPage.open()
                .login();
        BodyStats bodyStats = BodyStatsFactory.get();
        boolean isBodyStatsOpened = logWorkoutPage.open()
                .clickAddBodyStatsButton()
                .createBodyStats(bodyStats)
                .isPageOpen();

        assertTrue(isBodyStatsOpened, "Body Stats form hasn't opened");

        assertEquals(logWorkoutPage.getBodyStatsValue("Weight"), bodyStats.getWeight(), "The text doesn't match");
        assertEquals(logWorkoutPage.getBodyStatsValue("Body Fat"), bodyStats.getBodyFat(), "The text doesn't match");
        assertEquals(logWorkoutPage.getBodyStatsValue("Height"), bodyStats.getHeight(), "The text doesn't match");
        assertEquals(logWorkoutPage.getBodyStatsValue("Chest"), bodyStats.getChest(), "The text doesn't match");
        assertEquals(logWorkoutPage.getBodyStatsValue("Waist"), bodyStats.getWaist(), "The text doesn't match");
        assertEquals(logWorkoutPage.getBodyStatsValue("Arms"), bodyStats.getArms(), "The text doesn't match");
        assertEquals(logWorkoutPage.getBodyStatsValue("Shoulders"), bodyStats.getShoulders(), "The text doesn't match");
        assertEquals(logWorkoutPage.getBodyStatsValue("Foreams"), bodyStats.getForeams(), "The text doesn't match");
        assertEquals(logWorkoutPage.getBodyStatsValue("Neck"), bodyStats.getNeck(), "The text doesn't match");
        assertEquals(logWorkoutPage.getBodyStatsValue("Hips"), bodyStats.getHips(), "The text doesn't match");
        assertEquals(logWorkoutPage.getBodyStatsValue("Thighs"), bodyStats.getThighs(), "The text doesn't match");
        assertEquals(logWorkoutPage.getBodyStatsValue("Calves"), bodyStats.getCalves(), "The text doesn't match");

        logWorkoutPage.deleteBodyStats();

    }

    @Test
    public void sessionSummaryShouldBeCreated() {
        loginPage.open()
                .login();

        logWorkoutPage.open()
                .clickAddSessionSummaryButton()
                .createSessionSummary();

        assertTrue(logWorkoutPage.summaryIsCreated(), "Summary is not created");
    }

    @Test
    public void noteShouldBeCreated() throws InterruptedException {
        loginPage.open()
                .login();
        logWorkoutPage.open()
                .clickNotesAddButton()
                .createNote();

        assertEquals(logWorkoutPage.returnNoteFakerText(), logWorkoutPage.getNoteText(), "The text doesn't match");
    }

    @Test
    public void weightBodyPartShouldBeOpened() {
        loginPage.open()
                .login();
        BodyStats bodyStats = BodyStatsFactory.get();
        boolean weightIsOpened = logWorkoutPage.open()
                .clickAddBodyStatsButton()
                .createBodyStats(bodyStats)
                .moveIntoAWeightBodyPart()
                .weightIsOpenedAndBackToTheLogWorkoutPage();

        assertTrue(weightIsOpened, "Page is not opened");

        logWorkoutPage.deleteBodyStats();

    }

    @Test
    public void trainingShouldBeOpened() {
        loginPage.open()
                .login();
        boolean trainingIsOpened = logWorkoutPage.moveToTrainingStats()
                .trainingIsOpened();

        assertTrue(trainingIsOpened, "Page is not opened");


    }
}
