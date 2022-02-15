package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ExercisesTest extends BaseTest {

    @Test(description = "Open Exercise page")
    public void exercisePageShouldBeOpenedTest() {
        loginPage
                .open()
                .login();
        boolean isExercisesPageOpened = exercisesPage
                .openExercisePage()
                .isPageOpen();

        assertTrue(isExercisesPageOpened, "Exercises page hasn't opened");

    }

    @Test(description = "Open All Exercise page")
    public void allExercisePageShouldBeOpenedTest() {
        loginPage
                .open()
                .login();
        exercisesPage
                .openExercisePage()
                .openAllExerciseDatabase();
        boolean isAllExercisesDatabasePageOpened = allExerciseDatabasePage
                .isPageOpen();

        assertTrue(isAllExercisesDatabasePageOpened, "All Exercises Database page hasn't opened");

    }

}
